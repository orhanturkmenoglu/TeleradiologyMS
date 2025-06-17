package com.teleradms.hospital.service.infrastructure.persistence.adapter;

import com.teleradms.hospital.service.application.port.output.HospitalUserPartitionRepositoryPort;
import com.teleradms.hospital.service.domain.model.HospitalUserPartition;
import com.teleradms.hospital.service.infrastructure.persistence.mapper.HospitalUserPartitionDomainToEntityMapper;
import com.teleradms.hospital.service.infrastructure.persistence.mapper.HospitalUserPartitionEntityToDomainMapper;
import com.teleradms.hospital.service.infrastructure.persistence.repository.HospitalUserPartitionJpaRepository;

import java.util.List;
import java.util.UUID;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HospitalUserPartitionAdapter implements HospitalUserPartitionRepositoryPort {

    private final HospitalUserPartitionJpaRepository hospitalUserPartitionJpaRepository;

    @Override
    public HospitalUserPartition save(HospitalUserPartition hospitalUserPartition) {
        var entity = HospitalUserPartitionDomainToEntityMapper.map(hospitalUserPartition);
        var saved = hospitalUserPartitionJpaRepository.save(entity);
        return HospitalUserPartitionEntityToDomainMapper.map(saved);
    }

    @Override
    public void deleteById(UUID id) {
        hospitalUserPartitionJpaRepository.deleteById(id);
    }

    @Override
    public HospitalUserPartition findById(UUID id) {
        return hospitalUserPartitionJpaRepository.findById(id)
                .map(HospitalUserPartitionEntityToDomainMapper::map)
                .orElse(null); // Eğer global exception varsa burada throw da edebilirsin
    }

    @Override
    public List<HospitalUserPartition> findAllByUserId(UUID userId) {
        return hospitalUserPartitionJpaRepository.findAllByUserId(userId).stream()
                .map(HospitalUserPartitionEntityToDomainMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<HospitalUserPartition> findAllByCompanyId(UUID companyId) {
        return hospitalUserPartitionJpaRepository.findAllByCompanyId(companyId).stream()
                .map(HospitalUserPartitionEntityToDomainMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<HospitalUserPartition> findAllByPartitionCode(String partitionCode) {
        return hospitalUserPartitionJpaRepository.findAllByPartitionCode(partitionCode).stream()
                .map(HospitalUserPartitionEntityToDomainMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByUserIdAndPartitionCode(UUID userId, String partitionCode) {
        return hospitalUserPartitionJpaRepository.existsByUserIdAndPartitionCode(userId, partitionCode);
    }
}
