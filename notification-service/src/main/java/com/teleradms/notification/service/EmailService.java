package com.teleradms.notification.service;

import com.teleradms.common.lib.dto.NotificationEventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendSimpleEmail(NotificationEventDTO eventDTO) throws Exception {

    try {

        log.info("NotificationEventDto: {}", eventDTO.toString());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(eventDTO.getTo());
        message.setSubject(eventDTO.getSubject());
        message.setText(eventDTO.getMessage());

        log.info("SimpleMailMessage :{}", message.toString());

        javaMailSender.send(message);

        log.info("Email sent successfully to: {}", eventDTO.getTo());

    } catch (Exception exception){
        throw  new Exception("Exception : "+exception.getMessage());
    }
    }
}
