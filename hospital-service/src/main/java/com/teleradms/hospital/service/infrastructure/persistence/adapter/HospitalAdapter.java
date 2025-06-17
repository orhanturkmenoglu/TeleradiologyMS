package com.teleradms.hospital.service.infrastructure.persistence.adapter;

import com.teleradms.hospital.service.application.port.output.HospitalRepositoryPort;
import com.teleradms.hospital.service.domain.model.Hospital;
import com.teleradms.hospital.service.infrastructure.persistence.entities.HospitalEntity;
import com.teleradms.hospital.service.infrastructure.persistence.mapper.HospitalDomainToEntityMapper;
import com.teleradms.hospital.service.infrastructure.persistence.mapper.HospitalEntityToDomainMapper;
import com.teleradms.hospital.service.infrastructure.persistence.repository.HospitalJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class HospitalAdapter implements HospitalRepositoryPort {

    private final HospitalJpaRepository hospitalJpaRepository;

    @Override
    public Hospital save(Hospital hospital) {
        HospitalEntity entity = HospitalDomainToEntityMapper.map(hospital);
        HospitalEntity savedEntity = hospitalJpaRepository.save(entity);
        return HospitalEntityToDomainMapper.map(savedEntity);
    }

    @Override
    public Optional<Hospital> findById(UUID id) {
        return hospitalJpaRepository.findById(id)
                .map(HospitalEntityToDomainMapper::map);
    }

    @Override
    public void deleteById(UUID id) {
        hospitalJpaRepository.deleteById(id);
    }

    @Override
    public List<Hospital> findAll() {
        return hospitalJpaRepository.findAll().stream()
                .map(HospitalEntityToDomainMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Hospital> findAllActive() {
        return hospitalJpaRepository.findByIsActiveTrue().stream()
                .map(HospitalEntityToDomainMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Hospital> findByCity(String city) {
        return hospitalJpaRepository.findByCityIgnoreCase(city).stream()
                .map(HospitalEntityToDomainMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Hospital> findByNameContains(String namePart) {
        return hospitalJpaRepository.findByShortNameContainingIgnoreCaseOrFullTitleContainingIgnoreCase(namePart, namePart)
                .stream()
                .map(HospitalEntityToDomainMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Hospital> findDeleted() {
        return hospitalJpaRepository.findByIsDeletedTrue().stream()
                .map(HospitalEntityToDomainMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Hospital> findByTaxNumber(String taxNumber) {
        return hospitalJpaRepository.findByTaxNumber(taxNumber)
                .map(HospitalEntityToDomainMapper::map);
    }

}
