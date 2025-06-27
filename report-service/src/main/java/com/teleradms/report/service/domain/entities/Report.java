package com.teleradms.report.service.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "report_name", nullable = false)
    private String reportName;

    @Column(nullable = false)
    private boolean emergency;

    @Column(name = "modality_type", nullable = false)
    private String modalityType;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "template_id", nullable = false)
    private UUID templateId;
}
