package com.teleradms.audit.service.application.service;

import com.teleradms.audit.service.application.dto.request.CreateAuditLogRequestDTO;
import com.teleradms.audit.service.application.mapper.AuditLogMapper;
import com.teleradms.audit.service.application.port.input.AuditLogUseCase;
import com.teleradms.audit.service.application.port.output.AuditLogRepositoryPort;
import com.teleradms.audit.service.domain.entities.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditLogService implements AuditLogUseCase {

    private final AuditLogRepositoryPort auditLogRepositoryPort;

    @Override
    public void saveAuditLog(CreateAuditLogRequestDTO createAuditLogRequestDTO) {
        AuditLog auditLog = AuditLogMapper.toDomain(createAuditLogRequestDTO);
        auditLogRepositoryPort.saveAuditLog(auditLog);
    }
}
