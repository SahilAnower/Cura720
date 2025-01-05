package com.sahil.hms.staffs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportStaffDto extends UserDto{
    private String supportRole;
    private String department;
}
