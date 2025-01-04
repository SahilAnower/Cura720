package com.sahil.hms.patients.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    @NotNull
    @NotEmpty
    private String state;
    @NotNull
    @NotEmpty
    private String city;
    private String street;
    @NotNull
    @NotEmpty
    private String zipCode;
    @NotNull
    @NotEmpty
    private String country;
}
