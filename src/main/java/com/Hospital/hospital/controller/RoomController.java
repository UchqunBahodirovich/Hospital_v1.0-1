package com.Hospital.hospital.controller;


import com.Hospital.hospital.db.dao.interfaces.RoomDAO;
import com.Hospital.hospital.db.entities.Room;
import com.Hospital.hospital.db.enums.RoomType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomController {
    RoomDAO dao;

    public RoomController(RoomDAO roomDAO) {
        this.dao=roomDAO;
    }
    @GetMapping(value = "/get")
    public ResponseEntity<List<Room>> getAll(){
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Room> getById(@PathVariable int id){
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{type}")
    public ResponseEntity<Room> getByRoomType(@PathVariable RoomType type){
        return new ResponseEntity<>(dao.getByRoomType(type), HttpStatus.OK);
    }
//    @GetMapping(value = "/getBoxed")
//    public ResponseEntity<List<Room>> getBoxed(){
//        return new ResponseEntity<>(dao.getByBoxedIsFalse(), HttpStatus.OK);
//    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Room>> save(@Validated Room room){
        dao.save(room);
        return new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<Room>> deleteById(@PathVariable int id){
        dao.deleteById(id);
        return new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
    }
}
