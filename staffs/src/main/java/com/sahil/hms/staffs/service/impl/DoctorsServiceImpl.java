package com.sahil.hms.staffs.service.impl;

import com.sahil.hms.staffs.dto.DoctorDto;
import com.sahil.hms.staffs.entity.Doctor;
import com.sahil.hms.staffs.exception.UserNotFoundException;
import com.sahil.hms.staffs.mapper.GenericMapper;
import com.sahil.hms.staffs.repository.DoctorsRepository;
import com.sahil.hms.staffs.service.IDoctorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DoctorsServiceImpl implements IDoctorsService {

    private final DoctorsRepository doctorsRepository;
    private final GenericMapper genericMapper;

    @Override
    public void create(DoctorDto doctorDto) {
        doctorsRepository.save(genericMapper.toDoctor(doctorDto));
    }

    @Override
    public DoctorDto getById(Long id) {
        Doctor doctor = doctorsRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Doctor not found with id: " + id));
        return genericMapper.toDoctorDto(doctor);
    }

    @Override
    public void update(DoctorDto doctorDto) {
        // todo: implement this
    }

    @Override
    public void delete(Long id) {
        Doctor doctor = doctorsRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Doctor not found with id: " + id));
        doctorsRepository.delete(doctor);
    }
}
