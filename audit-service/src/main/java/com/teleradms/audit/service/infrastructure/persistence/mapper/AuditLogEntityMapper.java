package com.teleradms.audit.service.infrastructure.persistence.mapper;

import com.teleradms.audit.service.domain.entities.AuditLog;
import com.teleradms.audit.service.infrastructure.persistence.entity.AuditLogEntity;

public class AuditLogEntityMapper {

    public static AuditLog toDomain(AuditLogEntity entity){
        return AuditLog.builder()
                .id(entity.getId().toString())
                .serviceName(entity.getServiceName())
                .action(entity.getAction())
                .userId(entity.getUserId())
                .traceId(entity.getTraceId())
                .ipAddress(entity.getIpAddress())
                .requestData(entity.getRequestData())
                .responseData(entity.getResponseData())
                .description(entity.getDescription())
                .timestamp(entity.getCreatedAt())
                .build();
    }

    public static AuditLogEntity toEntity(AuditLog domain){
        return AuditLogEntity.builder()
                .serviceName(domain.getServiceName())
                .action(domain.getAction())
                .userId(domain.getUserId())
                .ipAddress(domain.getIpAddress())
                .requestData(domain.getRequestData())
                .responseData(domain.getResponseData())
                .description(domain.getDescription())
                .build();
    }
}
