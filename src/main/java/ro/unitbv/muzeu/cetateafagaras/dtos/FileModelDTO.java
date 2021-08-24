package ro.unitbv.muzeu.cetateafagaras.dtos;

import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import ro.unitbv.muzeu.cetateafagaras.models.FileModel;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileModelDTO {

  private Long fileId;
  private String fileName;
  private String fileType;
  private byte[] fileData;
  private Long roomId;

  public FileModelDTO(FileModel file) {
    this.fileId = file.getFileId();
    this.fileName = file.getFileName();
    this.fileType = file.getFileType();
    this.fileData = file.getFileData();
    this.roomId = file.getRoomId();
  }

  public FileModelDTO(MultipartFile file, Long roomId) {
    this.fileName = file.getOriginalFilename();
    this.fileType = file.getContentType();
    try {
      this.fileData = file.getBytes();
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.roomId = roomId;
  }
}
