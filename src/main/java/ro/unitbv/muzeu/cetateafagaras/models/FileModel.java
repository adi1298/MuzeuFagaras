package ro.unitbv.muzeu.cetateafagaras.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.unitbv.muzeu.cetateafagaras.dtos.FileModelDTO;

@Entity
@Table(name = "media_files")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long fileId;
  private String fileName;
  private String fileType;
  private byte[] fileData;
  private Long roomId;

  public FileModel(FileModelDTO room) {
    this.fileId = room.getFileId();
    this.fileName = room.getFileName();
    this.fileType = room.getFileType();
    this.fileData = room.getFileData();
    this.roomId = room.getRoomId();
  }
}
