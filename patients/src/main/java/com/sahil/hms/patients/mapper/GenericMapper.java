package com.sahil.hms.patients.mapper;

import com.sahil.hms.patients.dto.AddressDto;
import com.sahil.hms.patients.dto.PatientDto;
import com.sahil.hms.patients.entity.Address;
import com.sahil.hms.patients.entity.Patient;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface GenericMapper {

    @Mapping(source = "addressDto", target = "address")
    Patient toPatient(PatientDto patientDto);

    @Mapping(source = "address", target = "addressDto")
    PatientDto toPatientDto(Patient patient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "addressDto", target = "address")
    void updatePatientFromDto(PatientDto patientDto, @MappingTarget Patient patient);

    Address toAddress(AddressDto addressDto);

    AddressDto toAddress(Address address);

}
