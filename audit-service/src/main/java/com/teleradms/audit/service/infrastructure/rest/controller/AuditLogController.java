package com.teleradms.audit.service.infrastructure.rest.controller;

import com.teleradms.audit.service.application.dto.request.CreateAuditLogRequestDTO;
import com.teleradms.audit.service.application.port.input.AuditLogUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/audits")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogUseCase auditLogUseCase;


    @PostMapping
    public ResponseEntity<Void> createAuditLog(@RequestBody CreateAuditLogRequestDTO createAuditLogRequestDTO) {
        auditLogUseCase.saveAuditLog(createAuditLogRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
