package com.sahil.hms.appointments.repository;

import com.sahil.hms.appointments.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends JpaRepository<Payment, Long> {
}
