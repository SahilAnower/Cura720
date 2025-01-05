package com.sahil.hms.staffs.service.impl;

import com.sahil.hms.staffs.dto.SupportStaffDto;
import com.sahil.hms.staffs.entity.SupportStaff;
import com.sahil.hms.staffs.exception.UserNotFoundException;
import com.sahil.hms.staffs.mapper.GenericMapper;
import com.sahil.hms.staffs.repository.SupportStaffsRepository;
import com.sahil.hms.staffs.service.ISupportStaffsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportStaffsServiceImpl implements ISupportStaffsService {

    private final GenericMapper genericMapper;
    private final SupportStaffsRepository supportStaffsRepository;

    @Override
    public void create(SupportStaffDto supportStaffDto) {
        supportStaffsRepository.save(genericMapper.toSupportStaff(supportStaffDto));
    }

    @Override
    public SupportStaffDto getById(Long id) {
        SupportStaff supportStaff = supportStaffsRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Support staff not found with id: " + id));
        return genericMapper.toSupportStaffDto(supportStaff);
    }

    @Override
    public void update(SupportStaffDto supportStaffDto) {
        // todo: implement this
    }

    @Override
    public void delete(Long id) {
        SupportStaff supportStaff = supportStaffsRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Support staff not found with id: " + id));
        supportStaffsRepository.delete(supportStaff);
    }
}
