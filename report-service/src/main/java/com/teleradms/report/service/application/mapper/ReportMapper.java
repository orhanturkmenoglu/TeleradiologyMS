package com.teleradms.report.service.application.mapper;

import com.teleradms.report.service.application.dto.request.CreateReportRequestDTO;
import com.teleradms.report.service.application.dto.response.ReportResponseDTO;
import com.teleradms.report.service.domain.entities.Report;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    Report toDomain(CreateReportRequestDTO dto);

    ReportResponseDTO toResponse(Report report);
}