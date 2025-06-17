package com.teleradms.company.service.application.port.input;

import com.teleradms.company.service.application.dto.request.CreateCompanyRequestDTO;
import com.teleradms.company.service.application.dto.response.CompanyResponseDTO;

import java.util.List;
import java.util.UUID;
//bu interface clean architecture kapsaminda servicelerde kullanilacak methodlarin cercevesi icin yazildi
public interface CompanyUseCase {

   CompanyResponseDTO createCompany(CreateCompanyRequestDTO createMemberRequestDTO);

   CompanyResponseDTO getCompanyById(UUID id);

   List<CompanyResponseDTO> getAllCompanies();

   CompanyResponseDTO updateCompany(UUID companyId, CreateCompanyRequestDTO createMemberRequestDTO);

    void deleteCompany(UUID memberId);
}
