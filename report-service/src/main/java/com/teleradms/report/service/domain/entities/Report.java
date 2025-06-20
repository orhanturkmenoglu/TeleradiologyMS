package com.teleradms.report.service.domain.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {
    private String id;
    private String title;
    private String content;
    private String authorId;
}