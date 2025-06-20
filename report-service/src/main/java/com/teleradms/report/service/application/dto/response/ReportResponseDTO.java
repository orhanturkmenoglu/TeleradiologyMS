package com.teleradms.report.service.application.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportResponseDTO {
    private String id;
    private String title;
    private String content;
    private String authorId;
}