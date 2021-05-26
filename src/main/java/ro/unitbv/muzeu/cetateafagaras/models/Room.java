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
import ro.unitbv.muzeu.cetateafagaras.controllers.RoomDTO;


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
  private String title;
  private String description;
  private String images;
  private String audio;

  private String tourName;
  private String mapPosition;

  public Room(RoomDTO r) {
    this.id = r.getId();
    this.title = r.getTitle();
    this.description = r.getDescription();
    this.images = r.getImages();
    this.audio = r.getAudio();
    this.tourName = r.getTourName();
    this.mapPosition = r.getMapPosition();
  }

}
