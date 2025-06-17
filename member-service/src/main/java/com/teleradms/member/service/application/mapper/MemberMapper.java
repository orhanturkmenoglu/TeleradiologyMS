package com.teleradms.member.service.application.mapper;

import com.teleradms.member.service.application.dto.request.CreateMemberRequestDTO;
import com.teleradms.member.service.application.dto.request.UpdateMemberRequestDTO;
import com.teleradms.member.service.application.dto.response.MemberResponseDTO;
import com.teleradms.member.service.domain.entities.Member;

public class MemberMapper {

    public static Member toDomain(CreateMemberRequestDTO createMemberRequestDTO) {
        Member member = Member.builder()
                .id(null)
                .firstName(createMemberRequestDTO.getFirstName())
                .lastName(createMemberRequestDTO.getLastName())
                .phone(createMemberRequestDTO.getPhone())
                .email(createMemberRequestDTO.getEmail())
                .isActive(false)
                .applicationStatus(createMemberRequestDTO.getApplicationStatus())
                .areaOfInterestType(createMemberRequestDTO.getAreaOfInterestType())
                .build();

        return member;
    }

    public static MemberResponseDTO toResponse(Member member) {
        MemberResponseDTO memberResponse = MemberResponseDTO.builder()
                .id(member.getId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .phone(member.getPhone())
                .email(member.getEmail())
                .isActive(member.isActive())
                .applicationStatus(member.getApplicationStatus())
                .areaOfInterestType(member.getAreaOfInterestType())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
                .build();

        return memberResponse;
    }

    public static Member updateDomain(Member member, UpdateMemberRequestDTO updateMemberRequestDTO) {
        member.setPhone(updateMemberRequestDTO.getPhone());
        member.setEmail(updateMemberRequestDTO.getEmail());
        member.setApplicationStatus(updateMemberRequestDTO.getApplicationStatus());
        member.setAreaOfInterestType(updateMemberRequestDTO.getAreaOfInterestType());
        return member;
    }
    
}
