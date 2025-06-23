package com.teleradms.report.service.application.port.input;

import com.teleradms.report.service.application.dto.request.CreateReportRequestDTO;
import com.teleradms.report.service.application.dto.request.UpdateReportRequestDTO;
import com.teleradms.report.service.application.dto.response.ReportResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ReportUseCase {
    ReportResponseDTO createReport(CreateReportRequestDTO dto);

    ReportResponseDTO updateReport(UUID id, UpdateReportRequestDTO dto);

    void deleteReport(UUID id);

    ReportResponseDTO getReport(UUID id);

    List<ReportResponseDTO> getAllReports();
}