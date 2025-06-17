package com.teleradms.member.service.infrastructure.persistence.entity;

import com.teleradms.common.lib.base.BaseEntity;
import com.teleradms.member.service.domain.enums.ApplicationStatus;
import com.teleradms.member.service.domain.enums.AreaOfInterestType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity extends BaseEntity {

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private boolean isActive;

    private ApplicationStatus applicationStatus;

    private AreaOfInterestType areaOfInterestType;
}
