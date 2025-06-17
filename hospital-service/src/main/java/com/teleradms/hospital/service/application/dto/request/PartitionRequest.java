package com.teleradms.hospital.service.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request DTO for creating or updating a Partition")
public class PartitionRequest {

    @NotNull(message = "CompanyId is required")
    @Schema(description = "Unique identifier of the company", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    private UUID companyId;

    @NotNull(message = "HospitalId is required")
    @Schema(description = "Unique identifier of the hospital", example = "a123f1ee-6c54-4b01-90e6-d701748f0851")
    private UUID hospitalId;

    @NotNull(message = "PartitionType is required")
    @Schema(description = "Type of the partition", example = "RADIOLOGY")
    private String partitionType;

    @NotNull(message = "isActive is required")
    @Schema(description = "Indicates if the partition is active", example = "true")
    private Boolean isActive;

    @NotNull(message = "UrgentStatus is required")
    @Schema(description = "Urgency status of the partition", example = "URGENT")
    private String urgentStatus;

    @Schema(description = "Modality type", example = "CT")
    private String modalityType;

    @Size(max = 50)
    @Schema(description = "Partition code", example = "PART-001")
    private String partitionsCode;

    @Size(max = 255)
    @Schema(description = "Reference key", example = "REF123456")
    private String referenceKey;
}
