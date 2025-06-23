package com.teleradms.report.service.infrastructure.persistence;

import com.teleradms.common.lib.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportEntity extends BaseEntity {
    private String title;
    private String content;
    private String authorId;
}