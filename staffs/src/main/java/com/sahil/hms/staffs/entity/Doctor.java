package com.sahil.hms.staffs.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor extends User{
    private String specialization;
    private String department;
    @Column(name = "license_number")
    private String licenseNumber;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certification> certifications;
}
