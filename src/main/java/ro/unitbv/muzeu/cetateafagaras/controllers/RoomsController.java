package ro.unitbv.muzeu.cetateafagaras.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.unitbv.muzeu.cetateafagaras.dtos.RoomDTO;
import ro.unitbv.muzeu.cetateafagaras.services.RoomsService;

@RestController
public class RoomsController {

  @Autowired
  private RoomsService roomsService;

  @GetMapping(path = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public RoomDTO findRoomById(@PathVariable Long id) {
    return roomsService.findById(id);
  }

  @GetMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<RoomDTO> findAllRooms() {
    return roomsService.findAll();
  }

  @PostMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
  public RoomDTO saveRoom(@RequestBody RoomDTO room) {
    return roomsService.save(room);
  }

}
