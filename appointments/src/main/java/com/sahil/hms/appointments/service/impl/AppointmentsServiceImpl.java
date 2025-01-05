package com.sahil.hms.appointments.service.impl;

import com.sahil.hms.appointments.dto.AppointmentDto;
import com.sahil.hms.appointments.dto.SlotDto;
import com.sahil.hms.appointments.entity.Appointment;
import com.sahil.hms.appointments.exception.AppointmentNotFoundException;
import com.sahil.hms.appointments.mapper.GenericMapper;
import com.sahil.hms.appointments.repository.AppointmentsRepository;
import com.sahil.hms.appointments.service.IAppointmentsService;
import com.sahil.hms.appointments.service.ISlotsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentsServiceImpl implements IAppointmentsService {

    private final AppointmentsRepository appointmentsRepository;

    private final GenericMapper genericMapper;

    private final ISlotsService iSlotsService;

    @Transactional
    @Override
    public void create(AppointmentDto appointmentDto) {
        SlotDto slotDto = iSlotsService.getById(appointmentDto.getSlotId());
        Appointment appointment = genericMapper.toAppointment(appointmentDto);
        appointment.setSlot(genericMapper.toSlot(slotDto));
        appointmentsRepository.save(appointment);
        slotDto.setIsAvailable(false);
        iSlotsService.update(slotDto);
    }

    @Override
    public AppointmentDto getById(Long id) {
        Appointment appointment = appointmentsRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id: " + id));
        return genericMapper.toAppointmentDto(appointment);
    }

    @Override
    public List<AppointmentDto> getAllByPatientId(Long patientId) {
        return appointmentsRepository.findByPatientId(patientId).stream().map(genericMapper::toAppointmentDto).toList();
    }

    @Override
    public void cancel(Long id) {

    }

    @Override
    public void update(AppointmentDto appointmentDto) {

    }
}
