package com.teleradms.hospital.service.infrastructure.persistence.mapper;

import com.teleradms.hospital.service.domain.model.Hospital;
import com.teleradms.hospital.service.infrastructure.persistence.entities.HospitalEntity;

public class HospitalEntityToDomainMapper {

    public static Hospital map(HospitalEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("HospitalEntity cannot be null");
        }

        Hospital domain = new Hospital();

        domain.setId(entity.getId());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());

        domain.setShortName(entity.getShortName());
        domain.setFullTitle(entity.getFullTitle());
        domain.setAuthorizedPerson(entity.getAuthorizedPerson());
        domain.setCity(entity.getCity());
        domain.setDistrict(entity.getDistrict());
        domain.setPhone(entity.getPhone());
        domain.setEmail(entity.getEmail());
        domain.setAddress(entity.getAddress());
        domain.setTaxNumber(entity.getTaxNumber());
        domain.setTaxOffice(entity.getTaxOffice());
        domain.setWebsite(entity.getWebsite());
        domain.setDeleted(entity.isDeleted());
        domain.setActive(entity.isActive());
        domain.setCreatedAt(entity.getCreatedDate());
        domain.setUpdatedAt(entity.getUpdatedDate());

        return domain;
    }
}
