package com.teleradms.report.service.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateReportRequestDTO {

    @NotNull(message = "Id must not be null")
    private UUID id;

    @NotBlank(message = "Report name must not be blank")
    @Size(min = 3, max = 100, message = "Report name must be between 3 and 100 characters")
    private String reportName;

    @NotNull(message = "Emergency must not be null")
    private Boolean emergency;

    @NotBlank(message = "Modality type must not be blank")
    @Size(min = 2, max = 50, message = "Modality type must be between 2 and 50 characters")
    private String modalityType;

    @NotNull(message = "TemplateId must not be null")
    private UUID templateId;
}