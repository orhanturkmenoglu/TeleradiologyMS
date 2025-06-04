package com.teleradms.member.service.application.port.input;

import com.teleradms.member.service.application.dto.request.CreateMemberRequestDTO;
import com.teleradms.member.service.application.dto.request.UpdateMemberRequestDTO;
import com.teleradms.member.service.application.dto.response.MemberResponseDTO;

import java.util.List;
import java.util.UUID;

public interface MemberUseCase {

    MemberResponseDTO createMember(CreateMemberRequestDTO createMemberRequestDTO);

    MemberResponseDTO getMemberById(UUID memberId);

    List<MemberResponseDTO> getAllMembers();

    MemberResponseDTO updateMember(UUID memberId, UpdateMemberRequestDTO updateMemberRequestDTO);

    void deleteMember(UUID memberId);

}
