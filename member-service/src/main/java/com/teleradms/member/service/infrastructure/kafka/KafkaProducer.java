package com.teleradms.member.service.infrastructure.kafka;

import com.teleradms.common.lib.audit.AuditEvent;
import com.teleradms.common.lib.dto.NotificationEventDTO;
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

    @Value(value = "${spring.kafka.notification.topic.name}")
    private String NOTIFICATION_TOPIC;

    public void sendAuditLog(AuditEvent auditEvent) {
        log.info("Sending audit log to kafka: {}", auditEvent.toString());
        kafkaTemplate.send(AUDIT_TOPIC, auditEvent);
        log.info("Audit log sent to kafka");
    }

    public void sendNotification(NotificationEventDTO eventDTO) {
        log.info("📤 Sending notification to Kafka - To: {}, Subject: {}, Message: {}"
                , eventDTO.getTo(), eventDTO.getSubject(),eventDTO.getMessage());

        kafkaTemplate.send(NOTIFICATION_TOPIC, eventDTO);

        log.info("✅ Notification event sent to Kafka successfully - To: {}", eventDTO.getTo());
    }
}
