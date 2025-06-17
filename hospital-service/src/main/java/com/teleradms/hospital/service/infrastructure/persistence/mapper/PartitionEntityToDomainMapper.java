package com.teleradms.hospital.service.infrastructure.persistence.mapper;

import com.teleradms.hospital.service.domain.model.Partition;
import com.teleradms.hospital.service.infrastructure.persistence.entities.PartitionEntity;

public class PartitionEntityToDomainMapper {

    public static Partition map(PartitionEntity entity) {
        if (entity == null) {
            return null;
        }

        Partition domain = new Partition();

        domain.setId(entity.getId());
        domain.setCompanyId(entity.getCompanyId());
        domain.setHospital(HospitalEntityToDomainMapper.map(entity.getHospital()));
        domain.setPartitionType(entity.getPartitionType());
        domain.setIsActive(entity.getIsActive());
        domain.setUrgentStatus(entity.getUrgentStatus());
        domain.setModalityType(entity.getModalityType());
        domain.setPartitionsCode(entity.getPartitionsCode());
        domain.setReferenceKey(entity.getReferenceKey());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());

        return domain;
    }
}
