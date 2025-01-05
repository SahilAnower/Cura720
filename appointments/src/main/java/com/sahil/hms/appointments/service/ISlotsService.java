package com.sahil.hms.appointments.service;

import com.sahil.hms.appointments.dto.SlotDto;

public interface ISlotsService {

    void create(SlotDto slotDto);

    SlotDto getById(Long id);

    void update(SlotDto slotDto);

}
