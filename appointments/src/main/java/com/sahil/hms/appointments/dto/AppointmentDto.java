package com.sahil.hms.appointments.dto;

import com.sahil.hms.appointments.entity.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private Long id;

    private Long patientId;

    private Long slotId;

    private AppointmentStatus appointmentStatus;

}
