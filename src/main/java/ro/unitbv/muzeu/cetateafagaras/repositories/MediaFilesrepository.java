package ro.unitbv.muzeu.cetateafagaras.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.unitbv.muzeu.cetateafagaras.models.FileModel;

public interface MediaFilesrepository extends JpaRepository<FileModel, Long> {

  List<FileModel> findAllByRoomId(Long roomId);

  FileModel findByFileName(String filename);
}
