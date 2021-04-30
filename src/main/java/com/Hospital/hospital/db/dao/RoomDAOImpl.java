package com.Hospital.hospital.db.dao;

import com.Hospital.hospital.db.dao.interfaces.RoomDAO;
import com.Hospital.hospital.db.entities.Room;
import com.Hospital.hospital.db.enums.RoomType;
import com.Hospital.hospital.db.repositories.RoomRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoomDAOImpl implements RoomDAO {

    RoomRepository repo;

    public RoomDAOImpl(RoomRepository repository) {
        repo = repository;
    }

    @Override
    public List<Room> getAll() {
        return repo.findAll();
    }

    @Override
    public Room getById(int id) {
        return repo.findById(id);
    }

    @Override
    public Room getByRoomType(RoomType roomType) {
        return repo.findByRoomType(roomType);
    }

    //    @Override
    //    public List<Room> getByBoxedIsFalse() {
    //        return repo.findAllByBoxedFalse();
    //    }

    @Override
    public void save(Room room) {
        Room temp = repo.findById(room.getId());

        if (temp == null) {
            repo.save(room);
        } else {
            temp.setAmountOfBeds(room.getAmountOfBeds());
            temp.setCount(room.getCount());
            temp.setRoomType(room.getRoomType());
            repo.save(temp);
        }
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
