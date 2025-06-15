package com.teleradms.audit.service.infrastructure.persistence.repository;

import com.teleradms.audit.service.domain.entities.AuditLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditLogJpaRepository extends MongoRepository<AuditLog, String> {
}
