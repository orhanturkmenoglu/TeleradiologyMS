package com.teleradms.hospital.service.infrastructure.persistence.mapper;


import com.teleradms.hospital.service.domain.model.HospitalUserPartition;
import com.teleradms.hospital.service.infrastructure.persistence.entities.HospitalUserPartitionEntity;


public class HospitalUserPartitionEntityToDomainMapper {

    public static HospitalUserPartition map(HospitalUserPartitionEntity entity) {
        if (entity == null) return null;

        HospitalUserPartition domain = new HospitalUserPartition();
        domain.setId(entity.getId());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());

        domain.setUserId(entity.getUserId());
        domain.setCompanyId(entity.getCompanyId());
        domain.setUrgent(entity.getUrgent());
        domain.setModalityType(entity.getModalityType());
        domain.setReferenceKey(entity.getReferenceKey());
        domain.setPartitionCode(entity.getPartitionCode());
        domain.setCompanyCode(entity.getCompanyCode());

        domain.setPartition(PartitionEntityToDomainMapper.map(entity.getPartition()));
        domain.setHospital(HospitalEntityToDomainMapper.map(entity.getHospital()));

        return domain;
    }
}
