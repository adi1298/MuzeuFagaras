package ro.unitbv.muzeu.cetateafagaras.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.unitbv.muzeu.cetateafagaras.models.Room;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO {

  private Long id;
  private Long roomId;
  private String title;
  private String description;
  private String tourName;
  private String mapPosition;

  public RoomDTO(Room r) {
    this.id = r.getId();
    this.roomId = r.getRoomId();
    this.title = r.getTitle();
    this.description = r.getDescription();
    this.tourName = r.getTourName();
    this.mapPosition = r.getMapPosition();
  }

}
