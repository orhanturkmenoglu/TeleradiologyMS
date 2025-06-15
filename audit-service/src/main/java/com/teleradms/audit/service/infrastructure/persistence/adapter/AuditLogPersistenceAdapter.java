package com.teleradms.audit.service.infrastructure.persistence.adapter;

import com.teleradms.audit.service.application.port.output.AuditLogRepositoryPort;
import com.teleradms.audit.service.domain.entities.AuditLog;
import com.teleradms.audit.service.infrastructure.persistence.repository.AuditLogJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuditLogPersistenceAdapter implements AuditLogRepositoryPort {

    private final AuditLogJpaRepository auditLogJpaRepository;

    @Override
    public void saveAuditLog(AuditLog auditLog) {
        auditLogJpaRepository.save(auditLog);
    }
}
