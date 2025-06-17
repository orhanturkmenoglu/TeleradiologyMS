package com.teleradms.hospital.service.domain.model;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospital {
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
