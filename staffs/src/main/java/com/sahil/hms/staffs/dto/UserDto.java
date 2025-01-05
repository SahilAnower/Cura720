package com.sahil.hms.staffs.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DoctorDto.class, name = "doctor"),
        @JsonSubTypes.Type(value = NurseDto.class, name = "nurse"),
        @JsonSubTypes.Type(value = SupportStaffDto.class, name = "supportStaff")
})
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
