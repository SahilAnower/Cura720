package com.sahil.hms.staffs.repository;

import com.sahil.hms.staffs.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NursesRepository extends JpaRepository<Nurse, Long> {
}
