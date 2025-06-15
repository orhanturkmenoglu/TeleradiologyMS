package com.teleradms.audit.service.application.port.output;

import com.teleradms.audit.service.domain.entities.AuditLog;

public interface AuditLogRepositoryPort {

    void saveAuditLog(AuditLog auditLog);
}
