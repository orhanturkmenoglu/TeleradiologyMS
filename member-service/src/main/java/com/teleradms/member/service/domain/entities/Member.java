package com.teleradms.member.service.domain.entities;

import com.teleradms.member.service.domain.enums.ApplicationStatus;
import com.teleradms.member.service.domain.enums.AreaOfInterestType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private UUID id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private boolean isActive;

    private ApplicationStatus applicationStatus;

    private AreaOfInterestType areaOfInterestType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
