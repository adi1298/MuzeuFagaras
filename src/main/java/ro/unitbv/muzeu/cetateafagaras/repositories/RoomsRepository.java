package ro.unitbv.muzeu.cetateafagaras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.unitbv.muzeu.cetateafagaras.models.Room;

public interface RoomsRepository extends JpaRepository<Room, Long> {

}
