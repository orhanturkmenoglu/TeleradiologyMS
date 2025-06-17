package com.teleradms.hospital.service.application.port.input;
import com.teleradms.hospital.service.domain.model.Partition;

import java.util.List;
import java.util.UUID;

public interface PartitionUseCases {

    Partition findById(UUID id);

    List<Partition> findAllByCompanyId(UUID companyId);

    Partition createPartition(Partition partition);

    void deleteById(UUID id);

    Partition findByPartitionsCode(String partitionsCode);
}