package ro.unitbv.muzeu.cetateafagaras.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.unitbv.muzeu.cetateafagaras.models.Room;
import ro.unitbv.muzeu.cetateafagaras.repositories.RoomsRepository;

@RestController
public class TestController {

  @Autowired
  private RoomsRepository roomsRepository;

  @GetMapping(path = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public RoomDTO test(@PathVariable Long id) {

    return new RoomDTO(roomsRepository.getOne(id));
  }

  @GetMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<RoomDTO> getAllRooms() {

    List<Room> rooms = roomsRepository.findAll();
    List<RoomDTO> dtoRooms = new ArrayList<>();
    for (Room r : rooms) {
      dtoRooms.add(new RoomDTO(r));
    }

    return dtoRooms;
  }

  @PostMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
  public RoomDTO saveRoom(@RequestBody RoomDTO roomDTO) {
    //procesare

    return new RoomDTO(roomsRepository.save(new Room(roomDTO)));
  }
}
