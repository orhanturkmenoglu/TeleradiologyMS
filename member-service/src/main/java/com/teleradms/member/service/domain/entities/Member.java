package com.teleradms.member.service.domain.entities;

import com.teleradms.common.lib.base.BaseEntity;
import com.teleradms.member.service.domain.enums.ApplicationStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private boolean isActive;

    private ApplicationStatus applicationStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
