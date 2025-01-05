package com.sahil.hms.appointments.service;

import com.sahil.hms.appointments.dto.AppointmentDto;

import java.util.List;

public interface IAppointmentsService {

    void create(AppointmentDto appointmentDto);

    AppointmentDto getById(Long id);

    List<AppointmentDto> getAllByPatientId(Long patientId);

    void cancel(Long id);

    void update(AppointmentDto appointmentDto);

}
