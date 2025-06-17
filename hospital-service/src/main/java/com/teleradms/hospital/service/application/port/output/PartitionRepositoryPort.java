package com.teleradms.hospital.service.application.port.output;

import com.teleradms.hospital.service.domain.model.Partition;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartitionRepositoryPort {


    Optional<Partition> findById(UUID id);

    List<Partition> findAllByCompanyId(UUID companyId);

    Partition save(Partition partition);

    void deleteById(UUID id);

    Optional<Partition> findByPartitionsCode(String partitionsCode);
}
