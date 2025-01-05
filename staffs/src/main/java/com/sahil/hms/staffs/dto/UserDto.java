package com.sahil.hms.staffs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDto {
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Min(10)
    private String phone;
    private String dob;
}
