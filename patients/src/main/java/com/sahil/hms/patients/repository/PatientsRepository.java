package com.sahil.hms.patients.repository;

import com.sahil.hms.patients.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientsRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
}
