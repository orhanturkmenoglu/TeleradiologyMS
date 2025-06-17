package com.teleradms.company.service.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response DTO for a company")
public class CompanyResponseDTO {

    @Schema(description = "Unique identifier of the company", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Short title of the company", example = "Telerad")
    private String companySmallTitle;

    @Schema(description = "Full title of the company", example = "Teleradiology Medical Services Ltd.")
    private String companyTitle;

    @Schema(description = "Company representative full name", example = "Jane Doe")
    private String representative;

    @Schema(description = "Phone number of the company", example = "02121234567")
    private String phoneNumber;

    @Schema(description = "Email address of the company", example = "info@telerad.com")
    private String email;

    @Schema(description = "Physical address of the company", example = "Büyükdere Cd. No:100, Şişli, İstanbul")
    private String address;

    @Schema(description = "Tax number of the company", example = "1234567890")
    private String taxNo;

    @Schema(description = "Tax office of the company", example = "İstanbul Vergi Dairesi")
    private String taxOffice;

    @Schema(description = "Website of the company", example = "https://www.telerad.com")
    private String webSite;

    @Schema(description = "City where the company is located", example = "İstanbul")
    private String city;

    @Schema(description = "District where the company is located", example = "Şişli")
    private String district;

    @Schema(description = "Indicates whether the company is deleted or not", example = "false")
    private boolean isDeleted;

    @Schema(description = "Status of the company (active or inactive)", example = "true")
    private boolean status;

    @Schema(description = "Type of the company represented as an integer enum", example = "1")
    private Integer companyType;

    @Schema(description = "Date and time when the company was created", example = "2023-04-20T10:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "Date and time when the company was last updated", example = "2023-04-20T11:45:00")
    private LocalDateTime updatedAt;
}
