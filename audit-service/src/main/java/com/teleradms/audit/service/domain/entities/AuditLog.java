package com.teleradms.audit.service.domain.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    private String id;

    private String serviceName;

    private String action;

    private String userId;

    private String traceId;

    private String ipAddress;

    private Map<String, Object> requestData;

    private Map<String, Object> responseData;

    private String description;

    private LocalDateTime timestamp;

}
