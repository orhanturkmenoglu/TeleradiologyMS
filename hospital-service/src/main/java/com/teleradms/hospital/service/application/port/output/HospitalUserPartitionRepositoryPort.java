package com.teleradms.hospital.service.application.port.output;

import com.teleradms.hospital.service.domain.model.HospitalUserPartition;

import java.util.List;
import java.util.UUID;

public interface HospitalUserPartitionRepositoryPort {

    HospitalUserPartition save(HospitalUserPartition hospitalUserPartition);

    void deleteById(UUID id);

    HospitalUserPartition findById(UUID id);

    List<HospitalUserPartition> findAllByUserId(UUID userId);

    List<HospitalUserPartition> findAllByCompanyId(UUID companyId);

    List<HospitalUserPartition> findAllByPartitionCode(String partitionCode);

    boolean existsByUserIdAndPartitionCode(UUID userId, String partitionCode);
}
