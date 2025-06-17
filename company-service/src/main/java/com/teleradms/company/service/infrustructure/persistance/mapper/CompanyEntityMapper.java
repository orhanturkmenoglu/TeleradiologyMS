package com.teleradms.company.service.infrustructure.persistance.mapper;

import com.teleradms.company.service.domain.entities.Company;
import com.teleradms.company.service.infrustructure.persistance.entity.CompanyEntity;

//bu katman domain to entity  icin yazildi
public class CompanyEntityMapper {

    public static Company toDomain(CompanyEntity entity) {
        return Company.builder()
                .id(entity.getId())
                .companySmallTitle(entity.getCompanySmallTitle())
                .companyTitle(entity.getCompanyTitle())
                .representative(entity.getRepresentative())
                .phoneNumber(String.valueOf(entity.getPhoneNumber()))
                .email(entity.getEmail())
                .address(entity.getAddress())
                .taxNo(entity.getTaxNo())
                .taxOffice(entity.getTaxOffice())
                .webSite(entity.getWebSite())
                .city(entity.getCity())
                .district(entity.getDistrict())
                .companyType(entity.getCompanyType())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .isDeleted(entity.isDeleted())
                .build();
    }

    public static CompanyEntity toEntity(Company domain) {
       CompanyEntity entity = new CompanyEntity();
       entity.setId(domain.getId());
       entity.setCompanySmallTitle(domain.getCompanySmallTitle());
       entity.setCompanyTitle(domain.getCompanyTitle());
       entity.setRepresentative(domain.getRepresentative());
       entity.setPhoneNumber(domain.getPhoneNumber());
       entity.setEmail(domain.getEmail());
       entity.setAddress(domain.getAddress());
       entity.setTaxNo(domain.getTaxNo());
       entity.setTaxOffice(domain.getTaxOffice());
       entity.setWebSite(domain.getWebSite());
       entity.setCity(domain.getCity());
       entity.setDistrict(domain.getDistrict());
       entity.setCompanyType(domain.getCompanyType());
       entity.setCreatedAt(domain.getCreatedAt());
       entity.setUpdatedAt(domain.getUpdatedAt());
       entity.setDeleted(domain.isDeleted());

       return entity;

    }


}
