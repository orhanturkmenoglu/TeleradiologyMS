package com.teleradms.member.service.application.dto.request;

import com.teleradms.member.service.domain.enums.ApplicationStatus;
import com.teleradms.member.service.domain.enums.AreaOfInterestType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request DTO for updating a member")
public class UpdateMemberRequestDTO {

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Schema(description = "Phone number of the member", example = "1234567890")
    private String phone;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    @Schema(description = "Email address of the member", example = "john.doe@example.com")
    private String email;

    @NotNull(message = "Application status is required")
    @Schema(description = "Application status of the member", example = "APPROVED")
    private ApplicationStatus applicationStatus;

    @NotNull(message = "Area of interest type is required")
    @Schema(description = "Area of interest type of the member", example = "CARDIOLOGY")
    private AreaOfInterestType areaOfInterestType;

}
