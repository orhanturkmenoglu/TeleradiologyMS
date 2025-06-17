package com.teleradms.audit.service.application.mapper;

import com.teleradms.audit.service.application.dto.request.CreateAuditLogRequestDTO;
import com.teleradms.audit.service.application.dto.response.AuditLogResponseDTO;
import com.teleradms.audit.service.domain.entities.AuditLog;
import com.teleradms.common.lib.audit.AuditEvent;

public class AuditLogMapper {

    public static AuditLog toDomain(CreateAuditLogRequestDTO createAuditLogRequestDTO) {
        return AuditLog.builder()
                .serviceName(createAuditLogRequestDTO.getServiceName())
                .action(createAuditLogRequestDTO.getAction())
                .userId(createAuditLogRequestDTO.getUserId())
                .traceId(createAuditLogRequestDTO.getTraceId())
                .ipAddress(createAuditLogRequestDTO.getIpAddress())
                .requestData(createAuditLogRequestDTO.getRequestData())
                .responseData(createAuditLogRequestDTO.getResponseData())
                .description(createAuditLogRequestDTO.getDescription())
                .build();

    }

    public static AuditLogResponseDTO toResponse(AuditLog auditLog) {
        return AuditLogResponseDTO.builder()
                .id(auditLog.getId())
                .serviceName(auditLog.getServiceName())
                .action(auditLog.getAction())
                .userId(auditLog.getUserId())
                .ipAddress(auditLog.getIpAddress())
                .requestData(auditLog.getRequestData())
                .responseData(auditLog.getResponseData())
                .description(auditLog.getDescription())
                .timestamp(auditLog.getTimestamp())
                .build();
    }

    public static CreateAuditLogRequestDTO toDTO(AuditEvent auditEvent) {
        return CreateAuditLogRequestDTO.builder()
                .serviceName(auditEvent.getServiceName())
                .action(auditEvent.getAction())
                .userId(auditEvent.getUserId())
                .traceId(auditEvent.getTraceId())
                .ipAddress(auditEvent.getIpAddress())
                .requestData(auditEvent.getRequestData())
                .responseData(auditEvent.getResponseData())
                .description(auditEvent.getDescription())
                .build();
    }
}
