package com.teleradms.member.service.infrastructure.persistence.mapper;

import com.teleradms.member.service.domain.entities.Member;
import com.teleradms.member.service.infrastructure.persistence.entity.MemberEntity;

public class MemberEntityMapper {

    public static Member toDomain(MemberEntity entity) {
        return Member.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .isActive(entity.isActive())
                .applicationStatus(entity.getApplicationStatus())
                .areaOfInterestType(entity.getAreaOfInterestType())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static MemberEntity toEntity(Member domain) {

        MemberEntity entity = new MemberEntity();
        entity.setId(domain.getId());
        entity.setFirstName(domain.getFirstName());
        entity.setLastName(domain.getLastName());
        entity.setPhone(domain.getPhone());
        entity.setEmail(domain.getEmail());
        entity.setActive(domain.isActive());
        entity.setApplicationStatus(domain.getApplicationStatus());
        entity.setAreaOfInterestType(domain.getAreaOfInterestType());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());

        return entity;
    }
}
