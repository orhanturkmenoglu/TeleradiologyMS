package com.teleradms.hospital.service.application.mapper;

import com.teleradms.hospital.service.application.dto.request.HospitalUserPartitionRequest;
import com.teleradms.hospital.service.domain.model.Hospital;
import com.teleradms.hospital.service.domain.model.HospitalUserPartition;
import com.teleradms.hospital.service.domain.model.Partition;


public class HospitalUserPartitionRequestToDomainMapper {

    public static HospitalUserPartition map(HospitalUserPartitionRequest request) {
        HospitalUserPartition domain = new HospitalUserPartition();

        domain.setUserId(request.getUserId());
        domain.setCompanyId(request.getCompanyId());

        Partition partition = new Partition();
        partition.setId(request.getPartitionId());
        domain.setPartition(partition);

        Hospital hospital = new Hospital();
        hospital.setId(request.getHospitalId());
        domain.setHospital(hospital);

        domain.setUrgent(request.getUrgent());
        domain.setModalityType(request.getModalityType());
        domain.setReferenceKey(request.getReferenceKey());
        domain.setPartitionCode(request.getPartitionCode());
        domain.setCompanyCode(request.getCompanyCode());

        return domain;
    }
}
