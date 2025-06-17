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
@Schema(description = "Response DTO for Hospital details")
public class HospitalResponse {

    @Schema(description = "Unique identifier of the hospital", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    private UUID id;

    @Schema(description = "Short name of the hospital", example = "Acıbadem")
    private String shortName;

    @Schema(description = "Full title of the hospital", example = "Acıbadem Sağlık Grubu Hastanesi")
    private String fullTitle;

    @Schema(description = "Authorized person at the hospital", example = "Dr. Ahmet Yılmaz")
    private String authorizedPerson;

    @Schema(description = "City where the hospital is located", example = "İstanbul")
    private String city;

    @Schema(description = "District where the hospital is located", example = "Kadıköy")
    private String district;

    @Schema(description = "Phone number of the hospital", example = "02165554433")
    private String phone;

    @Schema(description = "Email address of the hospital", example = "info@acibadem.com")
    private String email;

    @Schema(description = "Full address of the hospital", example = "Bağdat Caddesi No:123, Kadıköy, İstanbul")
    private String address;

    @Schema(description = "Tax number of the hospital", example = "1234567890")
    private String taxNumber;

    @Schema(description = "Tax office name", example = "Kadıköy Vergi Dairesi")
    private String taxOffice;

    @Schema(description = "Website URL of the hospital", example = "https://www.acibadem.com.tr")
    private String website;

    @Schema(description = "Whether the hospital is currently deleted", example = "false")
    private boolean isDeleted;

    @Schema(description = "Whether the hospital is currently active", example = "true")
    private boolean isActive;

    @Schema(description = "Record creation date/time", example = "2025-06-17T12:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Record last update date/time", example = "2025-06-20T15:30:00")
    private LocalDateTime updatedAt;
}
