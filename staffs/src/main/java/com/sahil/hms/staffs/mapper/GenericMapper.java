package com.sahil.hms.staffs.mapper;

import com.sahil.hms.staffs.dto.CertificationDto;
import com.sahil.hms.staffs.dto.DoctorDto;
import com.sahil.hms.staffs.dto.NurseDto;
import com.sahil.hms.staffs.dto.SupportStaffDto;
import com.sahil.hms.staffs.entity.Certification;
import com.sahil.hms.staffs.entity.Doctor;
import com.sahil.hms.staffs.entity.Nurse;
import com.sahil.hms.staffs.entity.SupportStaff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface GenericMapper {

    @Mapping(source = "certificationDtos", target = "certifications")
    Doctor toDoctor(DoctorDto doctorDto);

    @Mapping(source = "certifications", target = "certificationDtos")
    DoctorDto toDoctorDto(Doctor doctor);

    @Mapping(source = "certificationDtos", target = "certifications")
    Nurse toNurse(NurseDto nurseDto);

    @Mapping(source = "certifications", target = "certificationDtos")
    NurseDto toNurseDto(Nurse nurse);

    SupportStaff toSupportStaff(SupportStaffDto supportStaffDto);

    SupportStaffDto toSupportStaffDto(SupportStaff supportStaff);

    Certification toCertification (CertificationDto certificationDto);

}
