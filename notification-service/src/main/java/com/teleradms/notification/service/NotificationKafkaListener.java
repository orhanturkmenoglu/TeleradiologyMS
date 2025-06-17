package com.teleradms.notification.service;

import com.teleradms.common.lib.dto.NotificationEventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationKafkaListener {

    private final EmailService emailService;

    @KafkaListener(
            topics = "notificationTopic",
            groupId = "notificationGroupId",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeNotification(@Payload NotificationEventDTO eventDTO) throws Exception {
        log.info("📥 [Kafka] Received Notification Event - Type: {}, To: {}, Subject: {}",
                eventDTO.getTo(), eventDTO.getSubject());

        try {
            emailService.sendSimpleEmail(eventDTO);
            log.info("📧 [Email] Notification email sent to: {}", eventDTO.getTo());

        } catch (Exception e) {
            log.error("❌ [Email] Error sending email: {}", e.getMessage());
            throw new Exception("Error sending email: " + e.getMessage());
        }
    }
}
