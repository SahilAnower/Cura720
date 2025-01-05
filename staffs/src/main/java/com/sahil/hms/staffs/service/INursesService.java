package com.sahil.hms.staffs.service;

import com.sahil.hms.staffs.dto.NurseDto;

public interface INursesService {
    void create(NurseDto nurseDto);
    NurseDto getById(Long id);
    void update(NurseDto nurseDto);
    void delete(Long id);
}
