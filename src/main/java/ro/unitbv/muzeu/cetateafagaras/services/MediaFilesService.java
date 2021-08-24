package ro.unitbv.muzeu.cetateafagaras.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ro.unitbv.muzeu.cetateafagaras.dtos.FileModelDTO;
import ro.unitbv.muzeu.cetateafagaras.models.FileModel;
import ro.unitbv.muzeu.cetateafagaras.repositories.MediaFilesrepository;

@Component
public class MediaFilesService {

  @Value("${files.import.path}")
  private String importPath;

  @Autowired
  private MediaFilesrepository mediaFilesrepository;

  public List<FileModelDTO> findAllByRoomId(Long roomId) {
    return mediaFilesrepository.findAllByRoomId(roomId).stream().map(FileModelDTO::new).collect(
        Collectors.toList());
  }

  public FileModelDTO findOneByName(String filename) {
    return new FileModelDTO(mediaFilesrepository.findByFileName(filename));
  }

  public FileModelDTO save(FileModelDTO fileModel) {
    return new FileModelDTO(mediaFilesrepository.save(new FileModel(fileModel)));
  }

  public Boolean importFilesFrompath() {
    File baseDir = new File(importPath);
    if (!baseDir.exists()) {
      throw new IllegalArgumentException("Folder not found");
    }

    try (Stream<Path> paths = Files.walk(Paths.get(importPath))) {
      paths
          .filter(Files::isRegularFile)
          .forEach(this::saveFileFromPath);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return true;
  }

  private void saveFileFromPath(Path file) {
    String filename = file.toFile().getName();
    String[] parts = filename.split("\\.");
    try {
      FileModel fm = new FileModel(null, filename, parts[parts.length - 1],
          Files.readAllBytes(file),
          Long.parseLong(file.getParent().toFile().getName()));
      mediaFilesrepository.save(fm);
      System.out.println(fm);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
