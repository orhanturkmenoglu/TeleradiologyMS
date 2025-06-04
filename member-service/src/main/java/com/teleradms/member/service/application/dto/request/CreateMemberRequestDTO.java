package com.teleradms.member.service.application.dto.request;

import com.teleradms.member.service.domain.enums.ApplicationStatus;
import com.teleradms.member.service.domain.enums.AreaOfInterestType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request DTO for creating a new member")
public class CreateMemberRequestDTO {

    @Schema(description = "First name of the member", example = "John")
    private String firstName;

    @Schema(description = "Last name of the member", example = "Doe")
    private String lastName;

    @Schema(description = "Phone number of the member", example = "1234567890")
    private String phone;

    @Schema(description = "Email address of the member", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Application status of the member", example = "APPROVED")
    private ApplicationStatus applicationStatus;

    @Schema(description = "Area of interest type of the member", example = "CARDIOLOGY")
    private AreaOfInterestType areaOfInterestType;

}
