package com.sahil.hms.staffs.service;

import com.sahil.hms.staffs.dto.UserDto;

public interface IStaffsService {
    void create(UserDto userDto);
    UserDto getById(Long id, String type);
}
