package com.teleradms.company.service.application.dto.request;

import com.teleradms.company.service.domain.enums.CompanyType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request DTO for creating a new company")
public class CreateCompanyRequestDTO {

    @NotEmpty(message = "Company small title is required")
    @Schema(description = "Short title for the company", example = "Telerad Inc.")
    private String companySmallTitle;

    @NotEmpty(message = "Company full title is required")
    @Schema(description = "Full title of the company", example = "Teleradiology Solutions Corporation")
    private String companyTitle;

    @NotEmpty(message = "Representative is required")
    @Schema(description = "Company representative full name", example = "Jane Smith")
    private String representative;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Schema(description = "Phone number of the company", example = "5551234567")
    private String phoneNumber;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    @Schema(description = "Email address of the company", example = "info@telerad.com")
    private String email;

    @NotEmpty(message = "Address is required")
    @Schema(description = "Address of the company", example = "1234 Business Ave, Suite 500")
    private String address;

    @NotEmpty(message = "Tax number is required")
    @Schema(description = "Tax number of the company", example = "1234567890")
    private String taxNo;

    @NotEmpty(message = "Tax office is required")
    @Schema(description = "Tax office name", example = "Istanbul Vergi Dairesi")
    private String taxOffice;

    @Schema(description = "Company website", example = "https://www.telerad.com")
    private String webSite;

    @NotEmpty(message = "City is required")
    @Schema(description = "City of the company", example = "Istanbul")
    private String city;

    @NotEmpty(message = "District is required")
    @Schema(description = "District of the company", example = "Kadikoy")
    private String district;

    @NotNull(message = "Company type is required")
    @Schema(description = "Active status of the company", example = "HOSPITAL")
    private CompanyType companyType;

   //@NotNull(message = "Company type value is required")
   //@Schema(description = "Type of the company represented as integer enum", example = "1")
   //private Integer companyTypeValue;
}
