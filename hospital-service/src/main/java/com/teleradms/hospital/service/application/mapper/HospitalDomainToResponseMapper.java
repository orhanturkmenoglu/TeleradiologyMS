package com.teleradms.hospital.service.application.mapper;

import com.teleradms.hospital.service.application.dto.response.HospitalResponse;
import com.teleradms.hospital.service.domain.model.Hospital;

public class HospitalDomainToResponseMapper {

    public static HospitalResponse map(Hospital domain) {
        if (domain == null) {
            throw new IllegalArgumentException("Hospital domain cannot be null");
        }

        HospitalResponse response = new HospitalResponse();

        response.setId(domain.getId());
        response.setCreatedAt(domain.getCreatedAt());
        response.setUpdatedAt(domain.getUpdatedAt());

        response.setShortName(domain.getShortName());
        response.setFullTitle(domain.getFullTitle());
        response.setAuthorizedPerson(domain.getAuthorizedPerson());
        response.setCity(domain.getCity());
        response.setDistrict(domain.getDistrict());
        response.setPhone(domain.getPhone());
        response.setEmail(domain.getEmail());
        response.setAddress(domain.getAddress());
        response.setTaxNumber(domain.getTaxNumber());
        response.setTaxOffice(domain.getTaxOffice());
        response.setWebsite(domain.getWebsite());
        response.setDeleted(domain.isDeleted());
        response.setActive(domain.isActive());

        return response;
    }
}
