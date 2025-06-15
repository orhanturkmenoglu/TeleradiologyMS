package com.teleradms.audit.service.infrastructure.kafka;

import com.teleradms.audit.service.application.dto.request.CreateAuditLogRequestDTO;
import com.teleradms.audit.service.application.mapper.AuditLogMapper;
import com.teleradms.audit.service.application.service.AuditLogService;
import com.teleradms.common.lib.audit.AuditEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuditConsumer {

    private final AuditLogService auditLogService;

    @Value("${spring.kafka.consumer.topic}")
    private String auditTopic;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @KafkaListener(
            topics = "#{__listener.auditTopic}",
            groupId = "#{__listener.groupId}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeAuditLog(@Payload AuditEvent auditEvent) {
        log.info("Consuming audit log from kafka: {}", auditEvent.toString());

        CreateAuditLogRequestDTO dto = AuditLogMapper.toDTO(auditEvent);

        auditLogService.saveAuditLog(dto);

        log.info("Audit log saved to database");
    }


}
