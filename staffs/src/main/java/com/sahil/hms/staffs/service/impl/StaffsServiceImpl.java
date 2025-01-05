package com.sahil.hms.staffs.service.impl;

import com.sahil.hms.staffs.dto.DoctorDto;
import com.sahil.hms.staffs.dto.NurseDto;
import com.sahil.hms.staffs.dto.SupportStaffDto;
import com.sahil.hms.staffs.dto.UserDto;
import com.sahil.hms.staffs.service.IDoctorsService;
import com.sahil.hms.staffs.service.INursesService;
import com.sahil.hms.staffs.service.IStaffsService;
import com.sahil.hms.staffs.service.ISupportStaffsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StaffsServiceImpl implements IStaffsService {

    private final INursesService iNursesService;
    private final IDoctorsService iDoctorsService;
    private final ISupportStaffsService iSupportStaffsService;

    @Override
    public void create(UserDto userDto) {
        if (userDto instanceof NurseDto nurseDto) {
            iNursesService.create(nurseDto);
        }else if (userDto instanceof DoctorDto doctorDto) {
            iDoctorsService.create(doctorDto);
        }else if (userDto instanceof SupportStaffDto supportStaffDto) {
            iSupportStaffsService.create(supportStaffDto);
        }else {
            throw new RuntimeException("Invalid request type");
        }
    }

    @Override
    public UserDto getById(Long id, String type) {
        return switch (type) {
            case "nurse" -> iNursesService.getById(id);
            case "doctor" -> iDoctorsService.getById(id);
            case "supportStaff" -> iSupportStaffsService.getById(id);
            default -> throw new RuntimeException("Invalid request type");
        };
    }
}
