package com.teleradms.audit.service.application.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogResponseDTO {
    private String id;
    private String serviceName;
    private String action;
    private String actor;
    private String userId;
    private String traceId;
    private String ipAddress;
    private Map<String, Object> requestData;
    private Map<String, Object> responseData;
    private String description;
    private LocalDateTime timestamp;
}
