package com.sahil.hms.staffs.service;

import com.sahil.hms.staffs.dto.SupportStaffDto;

public interface ISupportStaffsService {
    void create(SupportStaffDto supportStaffDto);
    SupportStaffDto getById(Long id);
    void update(SupportStaffDto supportStaffDto);
    void delete(Long id);
}
