package com.teleradms.hospital.service.application.dto.request;

import com.teleradms.hospital.service.domain.enums.Modality;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request DTO for creating or updating a hospital-user-partition relation")
public class HospitalUserPartitionRequest {

    @NotNull(message = "User ID is required")
    @Schema(description = "UUID of the user", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    private UUID userId;

    @NotNull(message = "Company ID is required")
    @Schema(description = "UUID of the company", example = "a1b2c3d4-5678-90ab-cdef-1234567890ab")
    private UUID companyId;

    @NotNull(message = "Partition ID is required")
    @Schema(description = "UUID of the partition", example = "f9b8a7c6-d5e4-3210-bcde-6543210987ab")
    private UUID partitionId;

    @NotNull(message = "Hospital ID is required")
    @Schema(description = "UUID of the hospital", example = "abc12345-def6-7890-ghij-klmnopqrstuv")
    private UUID hospitalId;

    @Schema(description = "Whether this partition is marked as urgent", example = "false")
    private Boolean urgent;

    @Schema(description = "Modality type used", example = "MRI")
    private Modality modalityType;

    @Schema(description = "Reference key for the user-partition relation", example = "ref-abc-001")
    private String referenceKey;

    @NotEmpty(message = "Partition code is required")
    @Schema(description = "Code of the partition", example = "RAD-001")
    private String partitionCode;

    @NotEmpty(message = "Company code is required")
    @Schema(description = "Code of the company", example = "CMP-2024")
    private String companyCode;
}
