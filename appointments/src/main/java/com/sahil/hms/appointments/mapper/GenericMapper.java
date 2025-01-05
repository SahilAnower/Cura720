package com.sahil.hms.appointments.mapper;


import com.sahil.hms.appointments.dto.AppointmentDto;
import com.sahil.hms.appointments.dto.PaymentDto;
import com.sahil.hms.appointments.dto.SlotDto;
import com.sahil.hms.appointments.entity.Appointment;
import com.sahil.hms.appointments.entity.Payment;
import com.sahil.hms.appointments.entity.Slot;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface GenericMapper {

    Appointment toAppointment(AppointmentDto appointmentDto);

    AppointmentDto toAppointmentDto(Appointment appointment);

    Slot toSlot(SlotDto slotDto);

    SlotDto toSlotDto(Slot slot);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSlotFromDto(SlotDto slotDto, @MappingTarget Slot slot);

    Payment toPayment(PaymentDto paymentDto);

    PaymentDto toPaymentDto(Payment payment);

}
