package com.sahil.hms.staffs.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto extends UserDto{
    @NotNull
    @NotEmpty
    private String specialization;
    @NotNull
    @NotEmpty
    private String department;
    private String licenseNumber;

    private List<CertificationDto> certificationDtos;

}
