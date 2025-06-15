package com.teleradms.hospital.service.infrastructure.persistence.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalEntity  extends BaseEntity{
    private UUID id;
    private String shortName;
    private String fullTitle;
    private String authorizedPerson;
    private String city;
    private String district;
    private String phone;
    private String email;
    private String address;
    private String taxNumber;
    private String taxOffice;
    private String website;
    private boolean isDeleted;
    private boolean isActive;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

