package com.teleradms.report.service.infrastructure.persistence.adapter;

import com.teleradms.report.service.infrastructure.persistence.mapper.ReportEntityMapper;
import com.teleradms.report.service.application.port.output.ReportRepositoryPort;
import com.teleradms.report.service.domain.entities.Report;
import com.teleradms.report.service.infrastructure.persistence.ReportEntity;
import com.teleradms.report.service.infrastructure.persistence.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReportPersistenceAdapter implements ReportRepositoryPort {
    private final ReportRepository reportRepository;
    private final ReportEntityMapper mapper;

    @Override
    public Report save(Report report) {
        ReportEntity entity = mapper.toEntity(report);
        ReportEntity saved = reportRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Report> findById(UUID id) {
        return reportRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        reportRepository.deleteById(id);
    }
}