package com.Hospital.hospital.db.dao;

import com.Hospital.hospital.db.dao.interfaces.PatientDAO;
import com.Hospital.hospital.db.entities.Patient;
import com.Hospital.hospital.db.repositories.PatientRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PatientDAOImpl implements PatientDAO {

    PatientRepository repo;

    public PatientDAOImpl(PatientRepository repository) {
        repo = repository;
    }

    @Override
    public List<Patient> getAll() {
        return repo.findAll();
    }

    @Override
    public Patient getById(int id) {
        return repo.findById(id);
    }

    @Override
    public Patient getByLastName(String lastName) {
        return repo.findByPatientLastName(lastName);
    }

    @Override
    public List<Patient> getAllByArrivalDate(LocalDate date) {
        return repo.findAllByArrivalDate(date);
    }

    @Override
    public void save(Patient patient) {
        Patient temp = repo.findById(patient.getPatientId());
        if (temp == null) {
            repo.save(patient);
        } else {
            temp.setPatientFirstName(patient.getPatientFirstName());
            temp.setPatientLastName(patient.getPatientLastName());
            temp.setArrivalDate(patient.getArrivalDate());
            repo.save(temp);
        }
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
