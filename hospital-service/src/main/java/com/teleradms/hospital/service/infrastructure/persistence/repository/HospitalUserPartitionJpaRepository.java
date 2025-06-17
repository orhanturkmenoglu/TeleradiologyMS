package com.teleradms.hospital.service.infrastructure.persistence.repository;

import com.teleradms.hospital.service.infrastructure.persistence.entities.HospitalUserPartitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HospitalUserPartitionJpaRepository extends JpaRepository<HospitalUserPartitionEntity, UUID> {

    List<HospitalUserPartitionEntity> findAllByUserId(UUID userId);

    List<HospitalUserPartitionEntity> findAllByCompanyId(UUID companyId);

    List<HospitalUserPartitionEntity> findAllByPartitionCode(String partitionCode);

    boolean existsByUserIdAndPartitionCode(UUID userId, String partitionCode);
}
