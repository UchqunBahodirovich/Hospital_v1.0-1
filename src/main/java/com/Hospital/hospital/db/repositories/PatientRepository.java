package com.Hospital.hospital.db.repositories;

import com.Hospital.hospital.db.entities.Patient;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();
    Patient findById(int id);
    Patient findByPatientLastName(String lastName);
    List<Patient> findAllByArrivalDate(LocalDate date);
}
