package com.teleradms.hospital.service.infrastructure.persistence.mapper;

import com.teleradms.hospital.service.domain.model.Hospital;
import com.teleradms.hospital.service.infrastructure.persistence.entities.HospitalEntity;

import java.time.LocalDateTime;


public class HospitalDomainToEntityMapper {

    public static HospitalEntity map(Hospital domain) {
        if (domain == null) {
            throw new IllegalArgumentException("Hospital domain cannot be null");
        }

        HospitalEntity entity = new HospitalEntity();

        entity.setId(domain.getId());
        entity.setShortName(domain.getShortName());
        entity.setFullTitle(domain.getFullTitle());
        entity.setAuthorizedPerson(domain.getAuthorizedPerson());
        entity.setCity(domain.getCity());
        entity.setDistrict(domain.getDistrict());
        entity.setPhone(domain.getPhone());
        entity.setEmail(domain.getEmail());
        entity.setAddress(domain.getAddress());
        entity.setTaxNumber(domain.getTaxNumber());
        entity.setTaxOffice(domain.getTaxOffice());
        entity.setWebsite(domain.getWebsite());
        entity.setDeleted(domain.isDeleted());
        entity.setActive(domain.isActive());

        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(domain.getUpdatedAt() != null ? domain.getUpdatedAt() : LocalDateTime.now());

        return entity;
    }
}
