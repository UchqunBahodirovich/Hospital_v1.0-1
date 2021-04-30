package com.Hospital.hospital.db.repositories;

import com.Hospital.hospital.db.entities.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findById(Long userId);

    void deleteById(Long userId);
}
