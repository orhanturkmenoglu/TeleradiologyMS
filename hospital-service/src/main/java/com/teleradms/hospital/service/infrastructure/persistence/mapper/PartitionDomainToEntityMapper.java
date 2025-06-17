package com.teleradms.hospital.service.infrastructure.persistence.mapper;

import com.teleradms.hospital.service.domain.model.Partition;
import com.teleradms.hospital.service.infrastructure.persistence.entities.PartitionEntity;

public class PartitionDomainToEntityMapper {

    public static PartitionEntity map(Partition domain) {
        if (domain == null) {
            return null;
        }

        PartitionEntity entity = new PartitionEntity();

        entity.setId(domain.getId());
        entity.setCompanyId(domain.getCompanyId());
        entity.setHospital(HospitalDomainToEntityMapper.map(domain.getHospital()));
        entity.setPartitionType(domain.getPartitionType());
        entity.setIsActive(domain.getIsActive());
        entity.setUrgentStatus(domain.getUrgentStatus());
        entity.setModalityType(domain.getModalityType());
        entity.setPartitionsCode(domain.getPartitionsCode());
        entity.setReferenceKey(domain.getReferenceKey());

        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());

        return entity;
    }
}
