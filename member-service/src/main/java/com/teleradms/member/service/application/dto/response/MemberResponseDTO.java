package com.teleradms.member.service.application.dto.response;

import com.teleradms.member.service.domain.enums.ApplicationStatus;
import com.teleradms.member.service.domain.enums.AreaOfInterestType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response DTO for a member")
public class MemberResponseDTO {

    @Schema(description = "Unique identifier of the member", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "First name of the member", example = "John")
    private String firstName;

    @Schema(description = "Last name of the member", example = "Doe")
    private String lastName;

    @Schema(description = "Phone number of the member", example = "1234567890")
    private String phone;

    @Schema(description = "Email address of the member", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Flag indicating whether the member is active or not", example = "true")
    private boolean isActive;

    @Schema(description = "Application status of the member", example = "APPROVED")
    private ApplicationStatus applicationStatus;

    @Schema(description = "Area of interest type of the member", example = "CARDIOLOGY")
    private AreaOfInterestType areaOfInterestType;

    @Schema(description = "Date and time when the member was created", example = "2023-04-20T10:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "Date and time when the member was last updated", example = "2023-04-20T11:45:00")
    private LocalDateTime updatedAt;
}
