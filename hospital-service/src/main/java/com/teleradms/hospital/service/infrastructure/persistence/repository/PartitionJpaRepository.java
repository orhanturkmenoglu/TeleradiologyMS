package com.teleradms.hospital.service.infrastructure.persistence.repository;

import com.teleradms.hospital.service.infrastructure.persistence.entities.PartitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartitionJpaRepository extends JpaRepository<PartitionEntity, UUID> {
    List<PartitionEntity> findAllByCompanyId(UUID companyId);

    // PartitionsCode ile sorgulama
    Optional<PartitionEntity> findByPartitionsCode(String partitionsCode);
}
