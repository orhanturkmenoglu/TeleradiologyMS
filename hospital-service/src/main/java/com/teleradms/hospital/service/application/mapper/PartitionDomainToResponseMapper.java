package com.teleradms.hospital.service.application.mapper;


import com.teleradms.hospital.service.application.dto.response.PartitionResponse;
import com.teleradms.hospital.service.domain.model.Partition;


public class PartitionDomainToResponseMapper {

    public static PartitionResponse map(Partition partition) {
        if (partition == null) {
            return null;
        }

        return PartitionResponse.builder()
                .id(partition.getId())
                .companyId(partition.getCompanyId())
                .hospitalId(partition.getHospital() != null ? partition.getHospital().getId() : null)
                .partitionType(partition.getPartitionType() != null ? partition.getPartitionType().name() : null)
                .isActive(partition.getIsActive())
                .urgentStatus(partition.getUrgentStatus() != null ? partition.getUrgentStatus().name() : null)
                .modalityType(partition.getModalityType() != null ? partition.getModalityType().name() : null)
                .partitionsCode(partition.getPartitionsCode())
                .referenceKey(partition.getReferenceKey())
                .createdAt(partition.getCreatedAt())
                .updatedAt(partition.getUpdatedAt())
                .build();
    }
}
