package com.teleradms.hospital.service.web;


import com.teleradms.common.lib.dto.BaseResponse;
import com.teleradms.hospital.service.application.dto.request.HospitalUserPartitionRequest;
import com.teleradms.hospital.service.application.dto.response.HospitalUserPartitionResponse;
import com.teleradms.hospital.service.application.port.input.HospitalUserPartitionUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/api/v1/hospital-user-partitions")
@RequiredArgsConstructor
public class HospitalUserPartitionController {

    private final HospitalUserPartitionUseCases hospitalUserPartitionUseCases;

    @Operation(summary = "Create a new hospital user partition")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Hospital user partition created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<BaseResponse<HospitalUserPartitionResponse>> create(@Valid @RequestBody HospitalUserPartitionRequest request) {
        HospitalUserPartitionResponse saved = hospitalUserPartitionUseCases.createHospitalUserPartition(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.success(saved, "Hospital user partition created successfully", HttpStatus.CREATED.value()));
    }

    @Operation(summary = "Get hospital user partition by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hospital user partition found"),
            @ApiResponse(responseCode = "404", description = "Hospital user partition not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<HospitalUserPartitionResponse>> getById(@PathVariable UUID id) {
        HospitalUserPartitionResponse response = hospitalUserPartitionUseCases.getHospitalUserPartitionById(id);
        return ResponseEntity.ok(BaseResponse.success(response, "Hospital user partition found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Get all hospital user partitions by user ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hospital user partitions found")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<BaseResponse<List<HospitalUserPartitionResponse>>> getAllByUserId(@PathVariable UUID userId) {
        List<HospitalUserPartitionResponse> responses = hospitalUserPartitionUseCases.getAllByUserId(userId);
        return ResponseEntity.ok(BaseResponse.success(responses, "Hospital user partitions found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Get all hospital user partitions by company ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hospital user partitions found")
    })
    @GetMapping("/company/{companyId}")
    public ResponseEntity<BaseResponse<List<HospitalUserPartitionResponse>>> getAllByCompanyId(@PathVariable UUID companyId) {
        List<HospitalUserPartitionResponse> responses = hospitalUserPartitionUseCases.getAllByCompanyId(companyId);
        return ResponseEntity.ok(BaseResponse.success(responses, "Hospital user partitions found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Get all hospital user partitions by partition code")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hospital user partitions found")
    })
    @GetMapping("/partition-code/{partitionCode}")
    public ResponseEntity<BaseResponse<List<HospitalUserPartitionResponse>>> getAllByPartitionCode(@PathVariable String partitionCode) {
        List<HospitalUserPartitionResponse> responses = hospitalUserPartitionUseCases.getAllByPartitionCode(partitionCode);
        return ResponseEntity.ok(BaseResponse.success(responses, "Hospital user partitions found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Delete hospital user partition by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Hospital user partition deleted"),
            @ApiResponse(responseCode = "404", description = "Hospital user partition not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable UUID id) {
        hospitalUserPartitionUseCases.deleteHospitalUserPartitionById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(BaseResponse.success(null, "Hospital user partition deleted", HttpStatus.NO_CONTENT.value()));
    }
}