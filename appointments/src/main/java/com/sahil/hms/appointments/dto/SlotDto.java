package com.sahil.hms.appointments.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlotDto {

    private Long id;

    private Long doctorId;

    private LocalDateTime timeFrom;

    private LocalDateTime timeTo;

    private LocalDate slotDate;

    private Boolean isAvailable;

    private Double charges;

}
