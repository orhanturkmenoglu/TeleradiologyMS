package com.teleradms.company.service.application.service;

import com.teleradms.common.lib.exception.NotFoundException;
import com.teleradms.company.service.application.dto.request.CreateCompanyRequestDTO;
import com.teleradms.company.service.application.dto.request.UpdateCompanyRequestDTO;
import com.teleradms.company.service.application.dto.response.CompanyResponseDTO;
import com.teleradms.company.service.application.mapper.CompanyMapper;
import com.teleradms.company.service.application.port.input.CompanyUseCase;
import com.teleradms.company.service.application.port.output.CompanyRepositoryPort;
import com.teleradms.company.service.domain.entities.Company;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService implements CompanyUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    @Transactional
    @Override
    public CompanyResponseDTO createCompany(CreateCompanyRequestDTO createCompanyRequestDTO) {
        log.info("Create Company: {}", createCompanyRequestDTO);
        Company company = CompanyMapper.toDomain(createCompanyRequestDTO);

        Company savedCompany = companyRepositoryPort.save(company);
        log.info("Saved Company: {}", savedCompany);

        return CompanyMapper.toResponse(savedCompany);
    }


    @Cacheable(value = "company", key = "#companyId")
    @Override
    public CompanyResponseDTO getCompanyById(UUID companyId) {
        log.info("Get Company by id: {}", companyId);

        Company foundCompany = findCompanyById(companyId);

        log.info("Found Company: {}", foundCompany);

        return CompanyMapper.toResponse(foundCompany);
    }

    @Override
    public List<CompanyResponseDTO> getAllCompanies() {
        log.info("Get all companies");

        List<Company> foundCompanies = companyRepositoryPort.findAll();
        log.info("Found companies: {}", foundCompanies);

        return List.of();
    }


    @CacheEvict(value = "company", key = "#companyId")
    @Override
    public CompanyResponseDTO updateCompany(UUID companyId, UpdateCompanyRequestDTO updateCompanyRequestDTO) {
        log.info("Update Company: {}", updateCompanyRequestDTO);

        Company company = findCompanyById(companyId);

        Company updatedCompany = CompanyMapper.updateDomain(company, updateCompanyRequestDTO);
        Company savedCompany = companyRepositoryPort.save(updatedCompany);
        log.info("Updated Company: {}", savedCompany);

        return CompanyMapper.toResponse(savedCompany);
    }

    @CacheEvict(value = {"company", "companies"}, key = "#companyId", allEntries = true)
    @Override
    public void deleteCompany(UUID companyId) {
        log.info("Delete Company: {}", companyId);

        //company db de var mi?
        Company foundCompany = findCompanyById(companyId);

        companyRepositoryPort.deleteById(foundCompany.getId());
    }

    //bu method 3 yerde kullanılıyor. yardımcı bir method yazıldı ve ilgili yerden çağrıldı
    private Company findCompanyById(UUID companyId) {
        return companyRepositoryPort.findById(companyId).orElseThrow(
                () -> new NotFoundException("Company with id " + companyId + " not found")
        );
    }

}
