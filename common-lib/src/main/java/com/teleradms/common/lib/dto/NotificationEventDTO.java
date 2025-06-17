package com.teleradms.common.lib.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationEventDTO {
    private String to;
    private String subject;
    private String message;
}
