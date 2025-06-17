package com.teleradms.hospital.service.application.service;

import com.teleradms.hospital.service.application.dto.request.HospitalRequest;
import com.teleradms.hospital.service.application.dto.response.HospitalResponse;
import com.teleradms.hospital.service.application.mapper.HospitalDomainToResponseMapper;
import com.teleradms.hospital.service.application.mapper.HospitalRequestToDomainMapper;
import com.teleradms.hospital.service.application.port.input.HospitalUseCases;
import com.teleradms.hospital.service.application.port.output.HospitalRepositoryPort;
import com.teleradms.hospital.service.domain.model.Hospital;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class HospitalService implements HospitalUseCases {
    //todo daha sonra exception yazılacak.

    private final HospitalRepositoryPort hospitalRepositoryPort;

    @Override
    @Transactional
    public HospitalResponse createHospital(HospitalRequest hospitalRequest) {
        log.info("Creating hospital with shortName: {}", hospitalRequest.getShortName());
        Hospital hospital = HospitalRequestToDomainMapper.map(hospitalRequest);

        Hospital savedHospital = hospitalRepositoryPort.save(hospital);
        log.info("Hospital created with id: {}", savedHospital.getId());

        return HospitalDomainToResponseMapper.map(savedHospital);
    }

    @Override
    @Transactional
    public void deleteHospitalById(UUID id) {
        hospitalRepositoryPort.deleteById(id);
        log.info("Hospital deleted with id: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public HospitalResponse getHospitalById(UUID id) {
        return hospitalRepositoryPort.findById(id)
                .map(HospitalDomainToResponseMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<HospitalResponse> getAllHospitals() {
        return hospitalRepositoryPort.findAll()
                .stream()
                .map(HospitalDomainToResponseMapper::map)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HospitalResponse> getActiveHospitals() {
        return hospitalRepositoryPort.findAllActive()
                .stream()
                .map(HospitalDomainToResponseMapper::map)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HospitalResponse> getHospitalsByCity(String city) {
        return hospitalRepositoryPort.findByCity(city)
                .stream()
                .map(HospitalDomainToResponseMapper::map)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HospitalResponse> searchHospitalsByName(String name) {
        return hospitalRepositoryPort.findByNameContains(name)
                .stream()
                .map(HospitalDomainToResponseMapper::map)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HospitalResponse> getDeletedHospitals() {
        return hospitalRepositoryPort.findDeleted()
                .stream()
                .map(HospitalDomainToResponseMapper::map)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public HospitalResponse getHospitalByTaxNumber(String taxNumber) {
        return hospitalRepositoryPort.findByTaxNumber(taxNumber)
                .map(HospitalDomainToResponseMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found with tax number: " + taxNumber));
    }
}
