package com.teleradms.company.service.application.port.output;

import com.teleradms.company.service.domain.entities.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepositoryPort {

    Company save(Company company);

    Optional<Company> findById(UUID uuid);

    List<Company> findAll();

    void deleteById(UUID uuid);
}
