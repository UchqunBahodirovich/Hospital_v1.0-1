package com.Hospital.hospital.db.dao.interfaces;

import com.Hospital.hospital.db.entities.Patient;
import java.time.LocalDate;
import java.util.List;

public interface PatientDAO {
    List<Patient> getAll();

    Patient getById(int id);

    Patient getByLastName(String id);

    List<Patient> getAllByArrivalDate(LocalDate date);

    void save(Patient patient);

    void deleteById(int id);
}
