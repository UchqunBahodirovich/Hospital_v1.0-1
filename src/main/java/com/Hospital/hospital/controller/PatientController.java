package com.Hospital.hospital.controller;


import com.Hospital.hospital.db.dao.interfaces.PatientDAO;
import com.Hospital.hospital.db.entities.Patient;
import com.Hospital.hospital.db.entities.Room;
import com.Hospital.hospital.db.enums.RoomType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {
    PatientDAO dao;

    public PatientController(PatientDAO patientDAO){
        dao=patientDAO;
    }
    @GetMapping(value = "/get")
    public ResponseEntity<List<Patient>> getAll(){
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Patient> getById(@PathVariable int id){
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{lastName}")
    public ResponseEntity<Patient> getByRoomType(@PathVariable String lastName){
        return new ResponseEntity<>(dao.getByLastName(lastName), HttpStatus.OK);
    }
    @GetMapping(value = "/getBoxed/{date}")
    public ResponseEntity<List<Patient>> getByArrivalDate(@PathVariable LocalDate date){
        return new ResponseEntity<>(dao.getAllByArrivalDate(date), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Patient>> save(@Valid @PathVariable Patient patient){
        dao.save(patient);
        return new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<Patient>> deleteById(@PathVariable int id){
        dao.deleteById(id);
        return new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
    }
}
