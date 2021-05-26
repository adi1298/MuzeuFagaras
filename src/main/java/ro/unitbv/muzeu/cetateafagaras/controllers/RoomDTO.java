package ro.unitbv.muzeu.cetateafagaras.controllers;

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
  private String title;
  private String description;
  private String images;
  private String audio;
  private String tourName;
  private String mapPosition;

  public RoomDTO(Room r) {
    this.id = r.getId();
    this.title = r.getTitle();
    this.description = r.getDescription();
    this.images = r.getImages();
    this.audio = r.getAudio();
    this.tourName = r.getTourName();
    this.mapPosition = r.getMapPosition();
  }

}
