package com.teleradms.member.service.infrastructure.kafka;

import com.teleradms.common.lib.audit.AuditEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value(value = "${spring.kafka.topic.name}")
    private String AUDIT_TOPIC;

    public void sendAuditLog(AuditEvent auditEvent) {
        log.info("Sending audit log to kafka: {}", auditEvent);
        kafkaTemplate.send(AUDIT_TOPIC, auditEvent);
        log.info("Audit log sent to kafka");
    }
}
