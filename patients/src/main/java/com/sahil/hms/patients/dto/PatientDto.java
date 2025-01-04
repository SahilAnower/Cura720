package com.sahil.hms.patients.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @Email
    @NotNull
    private String email;
    @NotEmpty
    private String dob;
    @NotEmpty
    @Min(10)
    private String phone;
    private AddressDto addressDto;
}
