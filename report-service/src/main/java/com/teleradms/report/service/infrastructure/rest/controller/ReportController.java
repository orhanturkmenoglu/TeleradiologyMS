package com.teleradms.report.service.infrastructure.rest.controller;

import com.teleradms.common.lib.base.BaseResponse;
import com.teleradms.report.service.application.dto.request.CreateReportRequestDTO;
import com.teleradms.report.service.application.dto.request.UpdateReportRequestDTO;
import com.teleradms.report.service.application.dto.response.ReportResponseDTO;
import com.teleradms.report.service.application.port.input.ReportUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportUseCase reportUseCase;

    @PostMapping
    public ResponseEntity<BaseResponse<ReportResponseDTO>> create(@RequestBody CreateReportRequestDTO dto) {
        return ResponseEntity.ok(BaseResponse.success(reportUseCase.createReport(dto), "Report created", 201));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<ReportResponseDTO>>> getAll() {
        return ResponseEntity.ok(BaseResponse.success(reportUseCase.getAllReports(), "Reports listed", 200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ReportResponseDTO>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(BaseResponse.success(reportUseCase.getReport(id), "Report found", 200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<ReportResponseDTO>> update(@PathVariable UUID id, @RequestBody UpdateReportRequestDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(BaseResponse.success(reportUseCase.updateReport(dto), "Report updated", 200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable UUID id) {
        reportUseCase.deleteReport(id);
        return ResponseEntity.ok(BaseResponse.success(null, "Report deleted", 200));
    }
}