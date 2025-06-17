package com.teleradms.hospital.service.application.mapper;

import com.teleradms.hospital.service.application.dto.response.HospitalUserPartitionResponse;
import com.teleradms.hospital.service.domain.model.HospitalUserPartition;

public class HospitalUserPartitionDomainToResponseMapper {

 //todo partitionıd ve hospital ıd kısımları iyileştir sonra
    public static HospitalUserPartitionResponse map(HospitalUserPartition domain) {

        HospitalUserPartitionResponse response = new HospitalUserPartitionResponse();

        response.setId(domain.getId());
        response.setUserId(domain.getUserId());
        response.setCompanyId(domain.getCompanyId());

        response.setPartitionId(domain.getPartition() != null ? domain.getPartition().getId() : null);
        response.setHospitalId(domain.getHospital() != null ? domain.getHospital().getId() : null);

        response.setUrgent(domain.getUrgent());
        response.setModalityType(domain.getModalityType());
        response.setReferenceKey(domain.getReferenceKey());
        response.setPartitionCode(domain.getPartitionCode());
        response.setCompanyCode(domain.getCompanyCode());

        return response;
    }
}
