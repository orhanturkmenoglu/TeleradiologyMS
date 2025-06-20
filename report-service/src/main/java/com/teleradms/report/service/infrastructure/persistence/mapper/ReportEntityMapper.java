package com.teleradms.report.service.infrastructure.persistence.mapper;

import com.teleradms.report.service.domain.entities.Report;
import com.teleradms.report.service.infrastructure.persistence.ReportEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ReportEntityMapper {
    ReportEntity toEntity(Report report);
    Report toDomain(ReportEntity entity);
}