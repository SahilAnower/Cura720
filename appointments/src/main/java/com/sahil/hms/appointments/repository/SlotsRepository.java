package com.sahil.hms.appointments.repository;

import com.sahil.hms.appointments.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotsRepository extends JpaRepository<Slot, Long> {
}
