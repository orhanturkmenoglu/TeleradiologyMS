package com.teleradms.hospital.service.infrastructure.persistence.mapper;

import com.teleradms.hospital.service.domain.model.HospitalUserPartition;
import com.teleradms.hospital.service.infrastructure.persistence.entities.HospitalUserPartitionEntity;


public class HospitalUserPartitionDomainToEntityMapper {

    public static HospitalUserPartitionEntity map(HospitalUserPartition domain) {
        if (domain == null) return null;

        HospitalUserPartitionEntity entity = new HospitalUserPartitionEntity();
        entity.setId(domain.getId());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());

        entity.setUserId(domain.getUserId());
        entity.setCompanyId(domain.getCompanyId());
        entity.setUrgent(domain.getUrgent());
        entity.setModalityType(domain.getModalityType());
        entity.setReferenceKey(domain.getReferenceKey());
        entity.setPartitionCode(domain.getPartitionCode());
        entity.setCompanyCode(domain.getCompanyCode());

        entity.setPartition(PartitionDomainToEntityMapper.map(domain.getPartition()));
        entity.setHospital(HospitalDomainToEntityMapper.map(domain.getHospital()));

        return entity;
    }
}
