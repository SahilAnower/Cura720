package com.sahil.hms.staffs.repository;

import com.sahil.hms.staffs.entity.SupportStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportStaffsRepository extends JpaRepository<SupportStaff, Long> {
}
