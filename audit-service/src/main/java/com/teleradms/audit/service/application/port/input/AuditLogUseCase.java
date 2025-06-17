package com.teleradms.audit.service.application.port.input;

import com.teleradms.audit.service.application.dto.request.CreateAuditLogRequestDTO;

public interface AuditLogUseCase {

    void saveAuditLog(CreateAuditLogRequestDTO createAuditLogRequestDTO);
}
