package com.Hospital.hospital.db.repositories;

import com.Hospital.hospital.db.entities.Hospital;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findAll();

    Hospital findById(int id);
    //    Hospital findByAddress(String address);
}
