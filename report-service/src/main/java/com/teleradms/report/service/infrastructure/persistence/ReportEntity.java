package com.teleradms.report.service.infrastructure.persistence;

import com.teleradms.common.lib.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportEntity extends BaseEntity {

    @Column(name = "report_name", nullable = false, length = 100)
    private String reportName;

    @Column(name = "emergency", nullable = false)
    private boolean emergency;

    @Column(name = "modality_type", nullable = false, length = 50)
    private String modalityType;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "template_id", nullable = false)
    private UUID templateId;
}