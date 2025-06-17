package com.teleradms.hospital.service.infrastructure.persistence.adapter;


import com.teleradms.hospital.service.application.port.output.PartitionRepositoryPort;
import com.teleradms.hospital.service.domain.model.Partition;
import com.teleradms.hospital.service.infrastructure.persistence.entities.PartitionEntity;
import com.teleradms.hospital.service.infrastructure.persistence.mapper.PartitionDomainToEntityMapper;
import com.teleradms.hospital.service.infrastructure.persistence.mapper.PartitionEntityToDomainMapper;
import com.teleradms.hospital.service.infrastructure.persistence.repository.PartitionJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PartitionAdapter implements PartitionRepositoryPort {

    private final PartitionJpaRepository partitionJpaRepository;

    @Override
    public Optional<Partition> findById(UUID id) {
        return partitionJpaRepository.findById(id)
                .map(PartitionEntityToDomainMapper::map);
    }

    @Override
    public List<Partition> findAllByCompanyId(UUID companyId) {
        return partitionJpaRepository.findAllByCompanyId(companyId)
                .stream()
                .map(PartitionEntityToDomainMapper::map)
                .toList();
    }

    @Override
    public Partition save(Partition partition) {
        PartitionEntity entity = PartitionDomainToEntityMapper.map(partition);
        PartitionEntity savedEntity = partitionJpaRepository.save(entity);
        return PartitionEntityToDomainMapper.map(savedEntity);
    }

    @Override
    public void deleteById(UUID id) {
        partitionJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Partition> findByPartitionsCode(String partitionsCode) {
        return partitionJpaRepository.findByPartitionsCode(partitionsCode)
                .map(PartitionEntityToDomainMapper::map);
    }
}
