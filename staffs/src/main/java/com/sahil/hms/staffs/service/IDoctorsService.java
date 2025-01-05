package com.sahil.hms.staffs.service;

import com.sahil.hms.staffs.dto.DoctorDto;

public interface IDoctorsService {
    void create(DoctorDto doctorDto);
    DoctorDto getById(Long id);
    void update(DoctorDto doctorDto);
    void delete(Long id);
}
