package com.Hospital.hospital.db.repositories;

import com.Hospital.hospital.db.entities.Room;
import com.Hospital.hospital.db.enums.RoomType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAll();
    Room findById(int id);
    Room findByRoomType(RoomType roomType);
    Room findByCount(int id);
}
