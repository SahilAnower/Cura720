package com.sahil.hms.staffs.service.impl;

import com.sahil.hms.staffs.dto.NurseDto;
import com.sahil.hms.staffs.entity.Certification;
import com.sahil.hms.staffs.entity.Nurse;
import com.sahil.hms.staffs.exception.UserNotFoundException;
import com.sahil.hms.staffs.mapper.GenericMapper;
import com.sahil.hms.staffs.repository.NursesRepository;
import com.sahil.hms.staffs.service.INursesService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NursesServiceImpl implements INursesService {

    private final GenericMapper genericMapper;
    private final NursesRepository nursesRepository;

    @Transactional
    @Override
    public void create(NurseDto nurseDto) {
        Nurse nurse = genericMapper.toNurse(nurseDto);
        List<Certification> certifications = nurseDto.getCertificationDtos().stream()
                .map(certificationDto -> {
                    Certification certification = genericMapper.toCertification(certificationDto);
                    certification.setNurse(nurse);
                    return certification;
                }).toList();
        nurse.setCertifications(certifications);
        nursesRepository.save(nurse);
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
