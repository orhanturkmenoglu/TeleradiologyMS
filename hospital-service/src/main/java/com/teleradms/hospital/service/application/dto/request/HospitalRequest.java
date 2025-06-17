package com.teleradms.hospital.service.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request DTO for creating a new hospital")
public class HospitalRequest {

    @NotEmpty(message = "Short name is required")
    @Schema(description = "Short name of the hospital", example = "Acıbadem")
    private String shortName;

    @NotEmpty(message = "Full title is required")
    @Schema(description = "Full official title of the hospital", example = "Acıbadem Sağlık Grubu Hastanesi")
    private String fullTitle;

    @NotEmpty(message = "Authorized person name is required")
    @Schema(description = "Authorized person in the hospital", example = "Dr. Ahmet Yılmaz")
    private String authorizedPerson;

    @NotEmpty(message = "City is required")
    @Schema(description = "City where the hospital is located", example = "İstanbul")
    private String city;

    @NotEmpty(message = "District is required")
    @Schema(description = "District where the hospital is located", example = "Kadıköy")
    private String district;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Schema(description = "Phone number of the hospital", example = "2123456789")
    private String phone;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    @Schema(description = "Email address of the hospital", example = "info@acibadem.com")
    private String email;

    @NotEmpty(message = "Address is required")
    @Schema(description = "Address of the hospital", example = "Bağdat Caddesi No: 100, Kadıköy, İstanbul")
    private String address;

    @NotEmpty(message = "Tax number is required")
    @Schema(description = "Tax number of the hospital", example = "1234567890")
    private String taxNumber;

    @NotEmpty(message = "Tax office is required")
    @Schema(description = "Tax office of the hospital", example = "Kadıköy Vergi Dairesi")
    private String taxOffice;

    @Schema(description = "Website of the hospital", example = "https://www.acibadem.com")
    private String website;

    @Schema(description = "Indicates if the hospital is marked as deleted", example = "false")
    private boolean isDeleted;

    @Schema(description = "Indicates if the hospital is currently active", example = "true")
    private boolean isActive;
}