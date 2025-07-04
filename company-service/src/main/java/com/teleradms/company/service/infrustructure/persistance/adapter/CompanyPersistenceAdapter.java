package com.teleradms.company.service.infrustructure.persistance.adapter;

import com.teleradms.company.service.application.port.output.CompanyRepositoryPort;
import com.teleradms.company.service.domain.entities.Company;
import com.teleradms.company.service.infrustructure.persistance.entity.CompanyEntity;
import com.teleradms.company.service.infrustructure.persistance.mapper.CompanyEntityMapper;
import com.teleradms.company.service.infrustructure.persistance.repository.CompanyRepository;
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
public class CompanyPersistenceAdapter implements CompanyRepositoryPort {
    private final CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        log.info("CompanyPersistenceAdapter::save  Saving company: {}", company);

        CompanyEntity savedCompany = companyRepository.save(CompanyEntityMapper.toEntity(company));
        return CompanyEntityMapper.toDomain(savedCompany);
    }

    @Override
    public Optional<Company> findById(UUID uuid) {
        log.info("CompanyPersistenceAdapter::findById  Finding company by id: {}", uuid);

        return companyRepository.findById(uuid)
                .map(CompanyEntityMapper::toDomain);
    }

    @Override
    public List<Company> findAll() {
        log.info("CompanyPersistenceAdapter::findAll  Fetching all companies");

        return companyRepository.findAll()
                .stream()
                .map(CompanyEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID uuid) {
        log.info("CompanyPersistenceAdapter::deleteById  Deleting company by id: {}", uuid);

        companyRepository.deleteById(uuid);
    }
}
