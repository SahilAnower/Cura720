package com.sahil.hms.appointments.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    private Slot slot;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "appointment_status")
    private AppointmentStatus appointmentStatus;

    // todo: reference to payment

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

}
