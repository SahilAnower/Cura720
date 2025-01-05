package com.sahil.hms.staffs.repository;

import com.sahil.hms.staffs.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctor, Long> {
}
