package com.teleradms.hospital.service.application.service;


import com.teleradms.hospital.service.application.dto.request.HospitalUserPartitionRequest;
import com.teleradms.hospital.service.application.dto.response.HospitalUserPartitionResponse;
import com.teleradms.hospital.service.application.mapper.HospitalUserPartitionDomainToResponseMapper;
import com.teleradms.hospital.service.application.mapper.HospitalUserPartitionRequestToDomainMapper;
import com.teleradms.hospital.service.application.port.input.HospitalUserPartitionUseCases;
import com.teleradms.hospital.service.application.port.output.HospitalUserPartitionRepositoryPort;
import com.teleradms.hospital.service.domain.model.HospitalUserPartition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class HospitalUserPartitionService implements HospitalUserPartitionUseCases {

    private final HospitalUserPartitionRepositoryPort hospitalUserPartitionRepositoryPort;

    @Override
    public HospitalUserPartitionResponse createHospitalUserPartition(HospitalUserPartitionRequest request) {
        HospitalUserPartition domain = HospitalUserPartitionRequestToDomainMapper.map(request);
        HospitalUserPartition saved = hospitalUserPartitionRepositoryPort.save(domain);
        return HospitalUserPartitionDomainToResponseMapper.map(saved);
    }

    @Override
    public HospitalUserPartitionResponse getHospitalUserPartitionById(UUID id) {
        HospitalUserPartition domain = hospitalUserPartitionRepositoryPort.findById(id);
        return HospitalUserPartitionDomainToResponseMapper.map(domain);
    }

    @Override
    public List<HospitalUserPartitionResponse> getAllByUserId(UUID userId) {
        List<HospitalUserPartition> domains = hospitalUserPartitionRepositoryPort.findAllByUserId(userId);
        return domains.stream()
                .map(HospitalUserPartitionDomainToResponseMapper::map)
                .toList();
    }

    @Override
    public List<HospitalUserPartitionResponse> getAllByCompanyId(UUID companyId) {
        List<HospitalUserPartition> domains = hospitalUserPartitionRepositoryPort.findAllByCompanyId(companyId);
        return domains.stream()
                .map(HospitalUserPartitionDomainToResponseMapper::map)
                .toList();
    }

    @Override
    public List<HospitalUserPartitionResponse> getAllByPartitionCode(String partitionCode) {
        List<HospitalUserPartition> domains = hospitalUserPartitionRepositoryPort.findAllByPartitionCode(partitionCode);
        return domains.stream()
                .map(HospitalUserPartitionDomainToResponseMapper::map)
                .toList();
    }

    @Override
    public void deleteHospitalUserPartitionById(UUID id) {
        hospitalUserPartitionRepositoryPort.deleteById(id);
    }

    @Override
    public boolean existsByUserIdAndPartitionCode(UUID userId, String partitionCode) {
        return hospitalUserPartitionRepositoryPort.existsByUserIdAndPartitionCode(userId, partitionCode);
    }
}
