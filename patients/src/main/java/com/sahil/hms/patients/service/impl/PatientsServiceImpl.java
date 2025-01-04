package com.sahil.hms.patients.service.impl;

import com.sahil.hms.patients.dto.PatientDto;
import com.sahil.hms.patients.entity.Patient;
import com.sahil.hms.patients.exception.PatientNotFoundException;
import com.sahil.hms.patients.mapper.GenericMapper;
import com.sahil.hms.patients.repository.PatientsRepository;
import com.sahil.hms.patients.service.IPatientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientsServiceImpl implements IPatientsService {

    private final PatientsRepository patientsRepository;
    private final GenericMapper genericMapper;

    @Override
    public void create(PatientDto patientDto) {
        patientsRepository.save(genericMapper.toPatient(patientDto));
    }

    @Override
    public PatientDto getById(Long id) {
        Patient patient = patientsRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));
        return genericMapper.toPatientDto(patient);
    }

    @Override
    public PatientDto getByEmail(String email) {
        Patient patient = patientsRepository.findByEmail(email).orElseThrow(() -> new PatientNotFoundException("Patient not found with email: " + email));
        return genericMapper.toPatientDto(patient);
    }

    @Override
    public void update(PatientDto patientDto) {
        Long patientId = patientDto.getId();
        if (patientId == null) {
            return;
        }
        Patient patient = patientsRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));

        genericMapper.updatePatientFromDto(patientDto, patient);

        patientsRepository.save(patient);
    }

    @Override
    public void delete(Long id) {
        Patient patient = patientsRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));
        patientsRepository.delete(patient);
    }
}
