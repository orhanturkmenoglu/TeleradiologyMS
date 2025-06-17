package com.teleradms.hospital.service.web;


import com.teleradms.common.lib.dto.BaseResponse;
import com.teleradms.hospital.service.application.dto.request.PartitionRequest;
import com.teleradms.hospital.service.application.dto.response.PartitionResponse;
import com.teleradms.hospital.service.application.port.input.PartitionUseCases;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;



import com.teleradms.hospital.service.application.mapper.PartitionDomainToResponseMapper;
import com.teleradms.hospital.service.application.mapper.PartitionRequestToDomainMapper;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/partitions")
@RequiredArgsConstructor
public class PartitionController {

    private final PartitionUseCases partitionUseCases;

    @Operation(summary = "Create a new partition")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Partition created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<BaseResponse<PartitionResponse>> create(@Valid @RequestBody PartitionRequest dto) {
        var domainPartition = PartitionRequestToDomainMapper.map(dto);
        var savedPartition = partitionUseCases.createPartition(domainPartition);
        var response = PartitionDomainToResponseMapper.map(savedPartition);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.success(response, "Partition created successfully", HttpStatus.CREATED.value()));
    }

    @Operation(summary = "Get a partition by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Partition found"),
            @ApiResponse(responseCode = "404", description = "Partition not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<PartitionResponse>> getById(@PathVariable UUID id) {
        var domainPartition = partitionUseCases.findById(id);
        var response = PartitionDomainToResponseMapper.map(domainPartition);
        return ResponseEntity.ok(BaseResponse.success(response, "Partition found", HttpStatus.OK.value()));
    }


    @Operation(summary = "Get all partitions by company ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Partitions found")
    })
    @GetMapping("/company/{companyId}")
    public ResponseEntity<BaseResponse<List<PartitionResponse>>> getAllByCompanyId(@PathVariable UUID companyId) {
        var domainPartitions = partitionUseCases.findAllByCompanyId(companyId);
        var responses = domainPartitions.stream()
                .map(PartitionDomainToResponseMapper::map)
                .collect(Collectors.toList());
        return ResponseEntity.ok(BaseResponse.success(responses, "Partitions found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Delete a partition")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Partition deleted"),
            @ApiResponse(responseCode = "404", description = "Partition not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable UUID id) {
        partitionUseCases.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(BaseResponse.success(null, "Partition deleted", HttpStatus.NO_CONTENT.value()));
    }
}
