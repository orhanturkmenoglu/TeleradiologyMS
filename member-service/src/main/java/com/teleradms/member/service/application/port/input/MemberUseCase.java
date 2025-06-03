package com.teleradms.member.service.application.port.input;

import java.util.List;
import java.util.UUID;

public interface MemberUseCase {

    MemberResponse createMember(CreateMemberRequest createMemberRequest);

    MemberResponse getMemberById(UUID memberId);

    List<MemberResponse> getAllMembers();

    MemberResponse updateMember(UUID memberId, UpdateMemberRequest updateMemberRequest);
}
