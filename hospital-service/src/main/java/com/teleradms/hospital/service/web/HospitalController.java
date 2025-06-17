package com.teleradms.hospital.service.web;


import com.teleradms.common.lib.base.BaseResponse;
import com.teleradms.hospital.service.application.dto.request.HospitalRequest;
import com.teleradms.hospital.service.application.dto.response.HospitalResponse;
import com.teleradms.hospital.service.application.port.input.HospitalUseCases;
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

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalUseCases hospitalUseCases;

    @Operation(summary = "Create a new hospital")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Hospital created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<BaseResponse<HospitalResponse>> create(@Valid @RequestBody HospitalRequest dto) {
        HospitalResponse hospital = hospitalUseCases.createHospital(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.success(hospital, "Hospital created successfully", HttpStatus.CREATED.value()));
    }

    @Operation(summary = "Get a hospital by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hospital found"),
            @ApiResponse(responseCode = "404", description = "Hospital not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<HospitalResponse>> getById(@PathVariable UUID id) {
        HospitalResponse hospital = hospitalUseCases.getHospitalById(id);
        return ResponseEntity.ok(BaseResponse.success(hospital, "Hospital found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Get all hospitals")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hospitals found")
    })
    @GetMapping
    public ResponseEntity<BaseResponse<List<HospitalResponse>>> getAll() {
        List<HospitalResponse> hospitals = hospitalUseCases.getAllHospitals();
        return ResponseEntity.ok(BaseResponse.success(hospitals, "Hospitals found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Delete a hospital")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Hospital deleted"),
            @ApiResponse(responseCode = "404", description = "Hospital not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable UUID id) {
        hospitalUseCases.deleteHospitalById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(BaseResponse.success(null, "Hospital deleted", HttpStatus.NO_CONTENT.value()));
    }

    @Operation(summary = "Get active hospitals")
    @GetMapping("/active")
    public ResponseEntity<BaseResponse<List<HospitalResponse>>> getActiveHospitals() {
        List<HospitalResponse> activeHospitals = hospitalUseCases.getActiveHospitals();
        return ResponseEntity.ok(BaseResponse.success(activeHospitals, "Active hospitals found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Get hospitals by city")
    @GetMapping("/city/{city}")
    public ResponseEntity<BaseResponse<List<HospitalResponse>>> getHospitalsByCity(@PathVariable String city) {
        List<HospitalResponse> hospitalsByCity = hospitalUseCases.getHospitalsByCity(city);
        return ResponseEntity.ok(BaseResponse.success(hospitalsByCity, "Hospitals found in city", HttpStatus.OK.value()));
    }

    @Operation(summary = "Search hospitals by name")
    @GetMapping("/search")
    public ResponseEntity<BaseResponse<List<HospitalResponse>>> searchHospitalsByName(@RequestParam String name) {
        List<HospitalResponse> hospitals = hospitalUseCases.searchHospitalsByName(name);
        return ResponseEntity.ok(BaseResponse.success(hospitals, "Hospitals found matching name", HttpStatus.OK.value()));
    }

    @Operation(summary = "Get deleted hospitals")
    @GetMapping("/deleted")
    public ResponseEntity<BaseResponse<List<HospitalResponse>>> getDeletedHospitals() {
        List<HospitalResponse> deletedHospitals = hospitalUseCases.getDeletedHospitals();
        return ResponseEntity.ok(BaseResponse.success(deletedHospitals, "Deleted hospitals found", HttpStatus.OK.value()));
    }

    @Operation(summary = "Get hospital by tax number")
    @GetMapping("/tax-number/{taxNumber}")
    public ResponseEntity<BaseResponse<HospitalResponse>> getHospitalByTaxNumber(@PathVariable String taxNumber) {
        HospitalResponse hospital = hospitalUseCases.getHospitalByTaxNumber(taxNumber);
        return ResponseEntity.ok(BaseResponse.success(hospital, "Hospital found", HttpStatus.OK.value()));
    }
}
