package ro.unitbv.muzeu.cetateafagaras.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unitbv.muzeu.cetateafagaras.dtos.RoomDTO;
import ro.unitbv.muzeu.cetateafagaras.models.Room;
import ro.unitbv.muzeu.cetateafagaras.repositories.RoomsRepository;

@Component
public class RoomsService {

  @Autowired
  private RoomsRepository roomsRepository;

  public List<RoomDTO> findAll() {
    return roomsRepository.findAll().stream().map(RoomDTO::new).collect(Collectors.toList());
  }

  public RoomDTO findById(Long id) {
    return new RoomDTO(roomsRepository.getOne(id));
  }

  public RoomDTO save(RoomDTO room) {
    return new RoomDTO(roomsRepository.save(new Room(room)));
  }

}
