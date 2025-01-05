package com.sahil.hms.staffs.service.impl;

import com.sahil.hms.staffs.dto.NurseDto;
import com.sahil.hms.staffs.entity.Nurse;
import com.sahil.hms.staffs.exception.UserNotFoundException;
import com.sahil.hms.staffs.mapper.GenericMapper;
import com.sahil.hms.staffs.repository.NursesRepository;
import com.sahil.hms.staffs.service.INursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NursesServiceImpl implements INursesService {

    private final GenericMapper genericMapper;
    private final NursesRepository nursesRepository;

    @Override
    public void create(NurseDto nurseDto) {
        nursesRepository.save(genericMapper.toNurse(nurseDto));
    }

    @Override
    public NurseDto getById(Long id) {
        Nurse nurse = nursesRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Nurse not found with id: " + id));
        return genericMapper.toNurseDto(nurse);
    }

    @Override
    public void update(NurseDto nurseDto) {
        // todo: implement this
    }

    @Override
    public void delete(Long id) {
        Nurse nurse = nursesRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Nurse not found with id: " + id));
        nursesRepository.delete(nurse);
    }
}
