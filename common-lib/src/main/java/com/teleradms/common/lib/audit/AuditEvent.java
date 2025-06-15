package com.teleradms.common.lib.audit;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditEvent {
    private String serviceName;
    private String action;
    private String userId;
    private String traceId;
    private String ipAddress;
    private Map<String, Object> requestData;
    private Map<String, Object> responseData;
    private String description;
}
