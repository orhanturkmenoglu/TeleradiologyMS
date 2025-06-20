package com.teleradms.report.service.application.service;

import com.teleradms.report.service.application.dto.request.CreateReportRequestDTO;
import com.teleradms.report.service.application.dto.request.UpdateReportRequestDTO;
import com.teleradms.report.service.application.dto.response.ReportResponseDTO;
import com.teleradms.report.service.application.mapper.ReportMapper;
import com.teleradms.report.service.application.port.input.ReportUseCase;
import com.teleradms.report.service.application.port.output.ReportRepositoryPort;
import com.teleradms.report.service.domain.entities.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReportService implements ReportUseCase {
    private final ReportRepositoryPort reportRepositoryPort;
    private final ReportMapper reportMapper;

    @Override
    public ReportResponseDTO createReport(CreateReportRequestDTO dto) {
        Report report = reportMapper.toDomain(dto);
        Report saved = reportRepositoryPort.save(report);
        return reportMapper.toResponse(saved);
    }

    @Override
    public ReportResponseDTO updateReport(UUID id, UpdateReportRequestDTO dto) {
        Report report = reportRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        report.setTitle(dto.getTitle());
        report.setContent(dto.getContent());
        Report updated = reportRepositoryPort.save(report);
        return reportMapper.toResponse(updated);
    }

    @Override
    public void deleteReport(UUID id) {
        reportRepositoryPort.deleteById(id);
    }

    @Override
    public ReportResponseDTO getReport(UUID id) {
        Report report = reportRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        return reportMapper.toResponse(report);
    }

    @Override
    public List<ReportResponseDTO> getAllReports() {
        return reportRepositoryPort.findAll().stream().map(reportMapper::toResponse).toList();
    }
}