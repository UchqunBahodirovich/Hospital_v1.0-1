package com.Hospital.hospital.db.dao.interfaces;

import com.Hospital.hospital.db.entities.Room;
import com.Hospital.hospital.db.enums.RoomType;
import java.util.List;

public interface RoomDAO {
    List<Room> getAll();
    Room getById(int id);
    Room getByRoomType(RoomType roomType);
    //    List<Room> getByBoxedIsFalse();

    void save(Room room);

    void deleteById(int id);
}
