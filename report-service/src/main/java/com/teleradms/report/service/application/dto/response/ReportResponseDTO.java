package com.teleradms.report.service.application.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportResponseDTO {
    private UUID id;
    private String reportName;
    private boolean emergency;
    private String modalityType;
    private boolean isDeleted;
    private UUID templateId;
}