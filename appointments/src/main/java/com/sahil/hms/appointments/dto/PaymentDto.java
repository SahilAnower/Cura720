package com.sahil.hms.appointments.dto;


import com.sahil.hms.appointments.entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private Long id;

    private PaymentStatus paymentStatus;

}
