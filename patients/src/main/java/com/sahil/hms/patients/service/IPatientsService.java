package com.sahil.hms.patients.service;

import com.sahil.hms.patients.dto.PatientDto;

public interface IPatientsService {
    void create(PatientDto patientDto);
    PatientDto getById(Long id);
    PatientDto getByEmail(String email);
    void update(PatientDto patientDto);
    void delete(Long id);
}
