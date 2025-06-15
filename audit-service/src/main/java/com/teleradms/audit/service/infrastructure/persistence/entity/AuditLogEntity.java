package com.teleradms.audit.service.infrastructure.persistence.entity;

import com.teleradms.common.lib.base.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "audit_logs")
public class AuditLogEntity extends BaseEntity {
    private String serviceName;

    private String action;

    private String userId;

    private String traceId;

    private String ipAddress;

    private Map<String, Object> requestData;

    private Map<String, Object> responseData;

    private String description;
}
