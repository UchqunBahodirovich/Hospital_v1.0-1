package com.Hospital.hospital.db.dao.interfaces;

import com.Hospital.hospital.db.entities.Hospital;
import java.util.List;

public interface HospitalDAO {
    List<Hospital> getAll();

    Hospital getById(int id);

    //    Hospital getByAddress(String address);

    void save(Hospital hospital);

    void deleteById(int id);
}
