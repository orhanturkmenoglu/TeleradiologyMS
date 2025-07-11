package com.teleradms.audit.service.infrastructure.persistence.adapter;

import com.teleradms.audit.service.application.port.output.AuditLogRepositoryPort;
import com.teleradms.audit.service.domain.entities.AuditLog;
import com.teleradms.audit.service.infrastructure.persistence.repository.AuditLogMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuditLogPersistenceAdapter implements AuditLogRepositoryPort {

    private final AuditLogMongoRepository auditLogMongoRepository;

    @Override
    public void saveAuditLog(AuditLog auditLog) {
        auditLogMongoRepository.save(auditLog);
    }
}
