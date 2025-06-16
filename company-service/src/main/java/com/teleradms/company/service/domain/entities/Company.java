package com.teleradms.company.service.domain.entities;

import com.teleradms.company.service.domain.enums.CompanyType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    private UUID id;

    private String companySmallTitle;

    private String companyTitle;

    private String representative;

    private String phoneNumber;

    private String email;

    private String address;

    private String taxNo;

    private String taxOffice;

    private String webSite;

    private String city;

    private String district;

    private CompanyType companyType;//sirket statuleri ne

    private boolean isDeleted;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
