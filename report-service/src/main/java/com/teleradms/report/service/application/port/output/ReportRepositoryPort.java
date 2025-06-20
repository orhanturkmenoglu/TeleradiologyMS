package com.teleradms.report.service.application.port.output;

import com.teleradms.report.service.domain.entities.Report;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReportRepositoryPort {
    Report save(Report report);

    Optional<Report> findById(UUID id);

    List<Report> findAll();

    void deleteById(UUID id);
}