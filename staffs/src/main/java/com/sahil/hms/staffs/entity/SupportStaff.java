package com.sahil.hms.staffs.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "support_staffs")
public class SupportStaff extends User {
    @Column(name = "support_role")
    private String supportRole;
    private String department;
}
