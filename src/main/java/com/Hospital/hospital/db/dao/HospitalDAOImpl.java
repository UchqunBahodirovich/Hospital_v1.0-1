package com.Hospital.hospital.db.dao;

import com.Hospital.hospital.db.dao.interfaces.HospitalDAO;
import com.Hospital.hospital.db.entities.Hospital;
import com.Hospital.hospital.db.repositories.HospitalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalDAOImpl implements HospitalDAO {

    HospitalRepository repo;

    public HospitalDAOImpl(HospitalRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Hospital> getAll() {
        return repo.findAll();
    }

    @Override
    public Hospital getById(int id) {
        return repo.findById(id);
    }

    //    @Override
    //    public Hospital getByAddress(String address) {
    //        return repo.findByAddress(address);
    //    }

    @Override
    public void save(Hospital hospital) {
        Hospital temp = repo.findById(hospital.getId());
        if (temp == null) {
            repo.save(hospital);
        } else {
            temp.setName(hospital.getName());
            //            temp.setAddress(hospital.getAddress());
            temp.setAvailableBeds(hospital.getAvailableBeds());
            temp.setCapacity(hospital.getCapacity());
            repo.save(temp);
        }
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
