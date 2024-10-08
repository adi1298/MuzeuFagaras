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
import ro.unitbv.muzeu.cetateafagaras.dtos.RoomDTO;


@Entity
@Table(name = "museum_rooms")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long roomId;
  private String title;
  private String description;
  private String tourName;
  private String mapPosition;


  public Room(RoomDTO r) {
    this.id = r.getId();
    this.roomId = r.getRoomId();
    this.title = r.getTitle();
    this.description = r.getDescription();
    this.tourName = r.getTourName();
    this.mapPosition = r.getMapPosition();
  }

}
