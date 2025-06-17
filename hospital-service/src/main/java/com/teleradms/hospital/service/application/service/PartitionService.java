package com.teleradms.hospital.service.application.service;


import com.teleradms.hospital.service.application.port.input.PartitionUseCases;
import com.teleradms.hospital.service.application.port.output.PartitionRepositoryPort;
import com.teleradms.hospital.service.domain.model.Partition;
import com.teleradms.hospital.service.infrastructure.persistence.mapper.PartitionDomainToEntityMapper;
import com.teleradms.hospital.service.infrastructure.persistence.mapper.PartitionEntityToDomainMapper;
import com.teleradms.hospital.service.infrastructure.persistence.repository.PartitionJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Slf4j
public class PartitionService implements PartitionUseCases {

    private final PartitionJpaRepository partitionJpaRepository;

    @Override
    @Transactional(readOnly = true)
    public Partition findById(UUID id) {
        log.info("Finding Partition by id: {}", id);
        return partitionJpaRepository.findById(id)
                .map(PartitionEntityToDomainMapper::map)
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Partition> findAllByCompanyId(UUID companyId) {
        log.info("Finding all Partitions by companyId: {}", companyId);
        return partitionJpaRepository.findAllByCompanyId(companyId)
                .stream()
                .map(PartitionEntityToDomainMapper::map)
                .toList();
    }

    @Override
    @Transactional
    public Partition createPartition(Partition partition) {
        log.info("Creating Partition: {}", partition);
        var entity = PartitionDomainToEntityMapper.map(partition);
        var savedEntity = partitionJpaRepository.save(entity);
        return PartitionEntityToDomainMapper.map(savedEntity);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        log.info("Deleting Partition by id: {}", id);
        partitionJpaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Partition findByPartitionsCode(String partitionsCode) {
        log.info("Finding Partition by partitionsCode: {}", partitionsCode);
        return partitionJpaRepository.findByPartitionsCode(partitionsCode)
                .map(PartitionEntityToDomainMapper::map)
                .orElse(null);
    }
}
