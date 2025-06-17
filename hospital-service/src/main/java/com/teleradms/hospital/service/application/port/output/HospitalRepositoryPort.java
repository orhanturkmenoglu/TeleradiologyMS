package com.teleradms.hospital.service.application.port.output;

import com.teleradms.hospital.service.domain.model.Hospital;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HospitalRepositoryPort {
    Hospital save(Hospital hospital);
    Optional<Hospital> findById(UUID id);
    void deleteById(UUID id);
    List<Hospital> findAll();
    List<Hospital> findAllActive();
    List<Hospital> findByCity(String city);
    List<Hospital> findByNameContains(String namePart);
    List<Hospital> findDeleted();
    Optional<Hospital> findByTaxNumber(String taxNumber);
}
