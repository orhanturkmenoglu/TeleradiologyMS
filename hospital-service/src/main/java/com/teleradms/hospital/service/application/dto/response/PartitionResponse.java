package com.teleradms.hospital.service.application.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response DTO for Partition details")
public class PartitionResponse {

    @Schema(description = "Unique identifier of the partition", example = "e1f2a3b4-c5d6-7e8f-9012-3456789abcde")
    private UUID id;

    @Schema(description = "Unique identifier of the company", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    private UUID companyId;

    @Schema(description = "Unique identifier of the hospital", example = "a123f1ee-6c54-4b01-90e6-d701748f0851")
    private UUID hospitalId;

    @Schema(description = "Type of the partition", example = "RADIOLOGY")
    private String partitionType;

    @Schema(description = "Indicates if the partition is active", example = "true")
    private Boolean isActive;

    @Schema(description = "Urgency status of the partition", example = "URGENT")
    private String urgentStatus;

    @Schema(description = "Modality type", example = "CT")
    private String modalityType;

    @Schema(description = "Partition code", example = "PART-001")
    private String partitionsCode;

    @Schema(description = "Reference key", example = "REF123456")
    private String referenceKey;

    @Schema(description = "Record creation date/time", example = "2025-06-17T12:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Record last update date/time", example = "2025-06-20T15:30:00")
    private LocalDateTime updatedAt;
}
