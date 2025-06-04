package com.teleradms.member.service.application.dto.request;

import com.teleradms.member.service.domain.enums.ApplicationStatus;
import com.teleradms.member.service.domain.enums.AreaOfInterestType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateMemberRequestDTO {

    private String phone;

    private String email;

    private ApplicationStatus applicationStatus;

    private AreaOfInterestType areaOfInterestType;

}
