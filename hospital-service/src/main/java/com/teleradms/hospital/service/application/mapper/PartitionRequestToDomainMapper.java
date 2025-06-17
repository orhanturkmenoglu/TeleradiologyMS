package com.teleradms.hospital.service.application.mapper;


import com.teleradms.hospital.service.application.dto.request.PartitionRequest;
import com.teleradms.hospital.service.domain.enums.Modality;
import com.teleradms.hospital.service.domain.enums.PartitionType;
import com.teleradms.hospital.service.domain.enums.UrgentStatus;
import com.teleradms.hospital.service.domain.model.Hospital;
import com.teleradms.hospital.service.domain.model.Partition;


public class PartitionRequestToDomainMapper {

    public static Partition map(PartitionRequest request) {

        Partition partition = new Partition();

        partition.setCompanyId(request.getCompanyId());

        Hospital hospital = new Hospital();
        hospital.setId(request.getHospitalId());
        partition.setHospital(hospital);

        partition.setPartitionType(PartitionType.valueOf(request.getPartitionType()));

        partition.setIsActive(request.getIsActive());

        partition.setUrgentStatus(UrgentStatus.valueOf(request.getUrgentStatus()));

        if (request.getModalityType() != null) {
            partition.setModalityType(Modality.valueOf(request.getModalityType()));
        }

        partition.setPartitionsCode(request.getPartitionsCode());

        partition.setReferenceKey(request.getReferenceKey());

        return partition;
    }
}
