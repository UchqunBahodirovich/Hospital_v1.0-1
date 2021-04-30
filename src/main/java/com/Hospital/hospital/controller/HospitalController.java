package com.Hospital.hospital.controller;

import com.Hospital.hospital.db.dao.interfaces.HospitalDAO;
import com.Hospital.hospital.db.entities.Hospital;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    HospitalDAO dao;

    public HospitalController(HospitalDAO dao) {
        this.dao=dao;
    }
    @GetMapping(value = "/get")
    public ResponseEntity<List<Hospital>> getAll(){
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Hospital> getById(@PathVariable int id){
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }
//    @GetMapping(value = "/get/{address}")
//    public ResponseEntity<Hospital> getByAddress(@PathVariable String address){
//        return new ResponseEntity<>(dao.getByAddress(address), HttpStatus.OK);
//    }
    @PostMapping(value = "/save")
    public ResponseEntity<List<Hospital>> saveHospital(@Valid @PathVariable Hospital hospital){
        dao.save(hospital);

        return new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<Hospital>> deleteById(@PathVariable int id){
        dao.deleteById(id);
        return new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
    }
}
