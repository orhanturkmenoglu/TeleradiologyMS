package com.teleradms.company.service.application.mapper;

import com.teleradms.company.service.application.dto.request.CreateCompanyRequestDTO;
import com.teleradms.company.service.application.dto.request.UpdateCompanyRequestDTO;
import com.teleradms.company.service.application.dto.response.CompanyResponseDTO;
import com.teleradms.company.service.domain.entities.Company;
//bu class dto-domain donusumu

public class CompanyMapper {

    public static Company toDomain(CreateCompanyRequestDTO createCompanyRequestDTO) {
        return Company.builder()
                .id(null)
                .companySmallTitle(createCompanyRequestDTO.getCompanySmallTitle())
                .companyTitle(createCompanyRequestDTO.getCompanyTitle())
                .representative(createCompanyRequestDTO.getRepresentative())
                .phoneNumber(createCompanyRequestDTO.getPhoneNumber())
                .email(createCompanyRequestDTO.getEmail())
                .address(createCompanyRequestDTO.getAddress())
                .taxNo(createCompanyRequestDTO.getTaxNo())
                .taxOffice(createCompanyRequestDTO.getTaxOffice())
                .webSite(createCompanyRequestDTO.getWebSite())
                .city(createCompanyRequestDTO.getCity())
                .district(createCompanyRequestDTO.getDistrict())
                .companyType(createCompanyRequestDTO.getCompanyType())
                .build();
    }

    public static CompanyResponseDTO toResponse(Company savedCompany) {
        return CompanyResponseDTO.builder()
                .id(savedCompany.getId())
                .companySmallTitle(savedCompany.getCompanySmallTitle())
                .companyTitle(savedCompany.getCompanyTitle())
                .representative(savedCompany.getRepresentative())
                .phoneNumber(savedCompany.getPhoneNumber())
                .email(savedCompany.getEmail())
                .address(savedCompany.getAddress())
                .taxNo(savedCompany.getTaxNo())
                .taxOffice(savedCompany.getTaxOffice())
                .webSite(savedCompany.getWebSite())
                .city(savedCompany.getCity())
                .district(savedCompany.getDistrict())
                .isDeleted(savedCompany.isDeleted())
                .createdAt(savedCompany.getCreatedAt())
                .updatedAt(savedCompany.getUpdatedAt())
                .build();
    }

    public static Company updateDomain(Company company, UpdateCompanyRequestDTO updateCompanyRequestDTO) {
        company.setCompanySmallTitle(updateCompanyRequestDTO.getCompanySmallTitle());
        company.setCompanyTitle(updateCompanyRequestDTO.getCompanyTitle());
        company.setRepresentative(updateCompanyRequestDTO.getRepresentative());
        company.setPhoneNumber(updateCompanyRequestDTO.getPhoneNumber());
        company.setEmail(updateCompanyRequestDTO.getEmail());
        company.setAddress(updateCompanyRequestDTO.getAddress());
        company.setTaxNo(updateCompanyRequestDTO.getTaxNo());
        company.setTaxOffice(updateCompanyRequestDTO.getTaxOffice());
        company.setWebSite(updateCompanyRequestDTO.getWebSite());
        company.setCity(updateCompanyRequestDTO.getCity());
        company.setDistrict(updateCompanyRequestDTO.getDistrict());
        company.setCompanyType(updateCompanyRequestDTO.getCompanyType());
        return company;
    }
}
