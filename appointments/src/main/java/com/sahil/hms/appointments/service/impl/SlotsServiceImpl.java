package com.sahil.hms.appointments.service.impl;

import com.sahil.hms.appointments.dto.SlotDto;
import com.sahil.hms.appointments.entity.Slot;
import com.sahil.hms.appointments.exception.SlotNotFoundException;
import com.sahil.hms.appointments.mapper.GenericMapper;
import com.sahil.hms.appointments.repository.SlotsRepository;
import com.sahil.hms.appointments.service.ISlotsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlotsServiceImpl implements ISlotsService {

    private final SlotsRepository slotsRepository;

    private final GenericMapper genericMapper;

    @Override
    public void create(SlotDto slotDto) {
        slotsRepository.save(genericMapper.toSlot(slotDto));
    }

    @Override
    public SlotDto getById(Long id) {
        Slot slot = slotsRepository.findById(id).orElseThrow(() -> new SlotNotFoundException("Slot not found with id: " + id));
        return genericMapper.toSlotDto(slot);
    }

    @Override
    public void update(SlotDto slotDto) {
        Long slotId = slotDto.getId();
        if (slotId == null) {
            throw new RuntimeException("Slot id cannot be null during update request");
        }
        Slot slot = slotsRepository.findById(slotId).orElseThrow(() -> new SlotNotFoundException("Slot not found with id: " + slotId));
        genericMapper.updateSlotFromDto(slotDto, slot);
        slotsRepository.save(slot);
    }
}
