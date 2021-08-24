package ro.unitbv.muzeu.cetateafagaras.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.unitbv.muzeu.cetateafagaras.dtos.FileModelDTO;
import ro.unitbv.muzeu.cetateafagaras.services.MediaFilesService;

@RestController
public class MediafilesController {

  @Autowired
  private MediaFilesService mediaFilesService;

  @GetMapping(path = "/{roomId}/files")
  public List<FileModelDTO> findRoomById(@PathVariable Long roomId) {
    return mediaFilesService.findAllByRoomId(roomId);
  }

  @GetMapping(path = "/files/{filename}")
  public FileModelDTO findAllRooms(@PathVariable String filename) {
    return mediaFilesService.findOneByName(filename);
  }

  @GetMapping(path = "/files/initial-load")
  public Boolean importFilesFrompath() {
    return mediaFilesService.importFilesFrompath();
  }

}
