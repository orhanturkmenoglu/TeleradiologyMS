package com.teleradms.hospital.service.application.mapper;

import com.teleradms.hospital.service.application.dto.request.HospitalRequest;
import com.teleradms.hospital.service.domain.model.Hospital;

import java.time.LocalDateTime;

public class HospitalRequestToDomainMapper {

    public static Hospital map(HospitalRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("HospitalRequest cannot be null");
        }

        Hospital domain = new Hospital();

        domain.setShortName(request.getShortName());
        domain.setFullTitle(request.getFullTitle());
        domain.setAuthorizedPerson(request.getAuthorizedPerson());
        domain.setCity(request.getCity());
        domain.setDistrict(request.getDistrict());
        domain.setPhone(request.getPhone());
        domain.setEmail(request.getEmail());
        domain.setAddress(request.getAddress());
        domain.setTaxNumber(request.getTaxNumber());
        domain.setTaxOffice(request.getTaxOffice());
        domain.setWebsite(request.getWebsite());
        domain.setDeleted(request.isDeleted());
        domain.setActive(request.isActive());
        domain.setCreatedAt(LocalDateTime.now());

        return domain;
    }
}
