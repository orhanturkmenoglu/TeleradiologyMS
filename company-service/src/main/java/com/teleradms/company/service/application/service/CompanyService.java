package com.teleradms.company.service.application.service;

import com.teleradms.company.service.application.dto.request.CreateCompanyRequestDTO;
import com.teleradms.company.service.application.dto.response.CompanyResponseDTO;
import com.teleradms.company.service.application.mapper.CompanyMapper;
import com.teleradms.company.service.application.port.input.CompanyUseCase;
import com.teleradms.company.service.application.port.output.CompanyRepositoryPort;
import com.teleradms.company.service.domain.entities.Company;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public CompanyResponseDTO getCompanyById(UUID id) {
        return null;
    }

    @Override
    public List<CompanyResponseDTO> getAllCompanies() {
        return List.of();
    }

    @Override
    public CompanyResponseDTO updateCompany(UUID companyId, CreateCompanyRequestDTO createMemberRequestDTO) {
        return null;
    }

    @Override
    public void deleteCompany(UUID memberId) {

    }
}
