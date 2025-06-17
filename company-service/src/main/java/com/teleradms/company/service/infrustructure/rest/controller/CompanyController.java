package com.teleradms.company.service.infrustructure.rest.controller;

import com.teleradms.common.lib.dto.BaseResponse;
import com.teleradms.company.service.application.dto.request.CreateCompanyRequestDTO;
import com.teleradms.company.service.application.dto.response.CompanyResponseDTO;
import com.teleradms.company.service.application.port.input.CompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyUseCase companyUseCase;

    @Operation(summary = "Creation a new company")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Company created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<BaseResponse<CompanyResponseDTO>> create(@Valid @RequestBody CreateCompanyRequestDTO createCompanyRequestDTO) {
        CompanyResponseDTO companyResponseDTO = companyUseCase.createCompany(createCompanyRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.success(companyResponseDTO, "Company created successfully", HttpStatus.CREATED.value()));
    }



    @Operation(summary = "Get a company by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Company found"),
            @ApiResponse(responseCode = "404", description = "Company not found")}
    )
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<CompanyResponseDTO>> getById(@PathVariable UUID id) {
        CompanyResponseDTO company = companyUseCase.getCompanyById(id);
        return ResponseEntity.ok(BaseResponse.success(company, "Company found", HttpStatus.OK.value()));
    }



}
