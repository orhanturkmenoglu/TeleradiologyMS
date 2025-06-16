package com.teleradms.company.service.infrustructure.persistance.entity;

import com.teleradms.common.lib.base.BaseEntity;
import com.teleradms.company.service.domain.enums.CompanyType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CompanyEntity extends BaseEntity {

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

    private CompanyType companyType;

    private boolean isDeleted = false;




}
