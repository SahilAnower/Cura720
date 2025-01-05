package com.sahil.hms.appointments.repository;

import com.sahil.hms.appointments.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPatientId(Long patientId);

}
