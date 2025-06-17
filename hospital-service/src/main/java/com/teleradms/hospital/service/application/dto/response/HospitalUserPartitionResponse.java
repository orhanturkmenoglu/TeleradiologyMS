package com.teleradms.hospital.service.application.dto.response;


import com.teleradms.hospital.service.domain.enums.Modality;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response DTO for hospital-user-partition relation")
public class HospitalUserPartitionResponse {

    @Schema(description = "ID of the hospital user partition record", example = "a1b2c3d4-5678-90ab-cdef-1234567890ab")
    private UUID id;

    @Schema(description = "UUID of the user", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    private UUID userId;

    @Schema(description = "UUID of the company", example = "e290f1ee-7d65-5c01-90e6-d701748f0123")
    private UUID companyId;

    @Schema(description = "UUID of the partition", example = "f9b8a7c6-d5e4-3210-bcde-6543210987ab")
    private UUID partitionId;

    @Schema(description = "UUID of the hospital", example = "abc12345-def6-7890-ghij-klmnopqrstuv")
    private UUID hospitalId;

    @Schema(description = "Whether this partition is marked as urgent", example = "true")
    private Boolean urgent;

    @Schema(description = "Modality type used", example = "CT")
    private Modality modalityType;

    @Schema(description = "Reference key for the user-partition relation", example = "ref-key-001")
    private String referenceKey;

    @Schema(description = "Code of the partition", example = "PART-001")
    private String partitionCode;

    @Schema(description = "Code of the company", example = "COMP-001")
    private String companyCode;
}
