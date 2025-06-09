package com.teleradms.member.service.application.service;

import com.teleradms.common.lib.exception.NotFoundException;
import com.teleradms.member.service.application.dto.request.CreateMemberRequestDTO;
import com.teleradms.member.service.application.dto.request.UpdateMemberRequestDTO;
import com.teleradms.member.service.application.dto.response.MemberResponseDTO;
import com.teleradms.member.service.application.mapper.MemberMapper;
import com.teleradms.member.service.application.port.input.MemberUseCase;
import com.teleradms.member.service.application.port.output.MemberRepositoryPort;
import com.teleradms.member.service.domain.entities.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService implements MemberUseCase {

    private final MemberRepositoryPort memberRepositoryPort;

    @Transactional
    @Override
    public MemberResponseDTO createMember(CreateMemberRequestDTO createMemberRequestDTO) {
        log.info("Creating member: {}", createMemberRequestDTO);
        Member member = MemberMapper.toDomain(createMemberRequestDTO);

        Member savedMember = memberRepositoryPort.save(member);
        log.info("Member created: {}", savedMember);

        return MemberMapper.toResponse(savedMember);
    }

    @Override
    public MemberResponseDTO getMemberById(UUID memberId) {
        log.info("Getting member by id: {}", memberId);

        Member member = memberRepositoryPort.
                findById(memberId).orElseThrow(() -> new NotFoundException("Member not found : "+memberId));

        log.info("Member found: {}", member);
        return MemberMapper.toResponse(member);
    }

    @Override
    public List<MemberResponseDTO> getAllMembers() {
        log.info("Getting all members");

        List<Member> members = memberRepositoryPort.findAll();
        log.info("Members found: {}", members);

        return members.stream().map(MemberMapper::toResponse).toList();
    }

    @Override
    public MemberResponseDTO updateMember(UUID memberId, UpdateMemberRequestDTO updateMemberRequestDTO) {
        log.info("Updating member: {}", updateMemberRequestDTO);

        Member member = memberRepositoryPort.
                findById(memberId).orElseThrow(() -> new NotFoundException("Member not found"));

        Member updatedMember = MemberMapper.updateDomain(member, updateMemberRequestDTO);
        Member savedMember = memberRepositoryPort.save(updatedMember);
        log.info("Member updated: {}", savedMember);


        return MemberMapper.toResponse(savedMember);
    }

    @Override
    public void deleteMember(UUID memberId) {
        log.info("Deleting member: {}", memberId);

        Member member = memberRepositoryPort.findById(memberId)
                .orElseThrow(() -> new NotFoundException("Member not found"));

        memberRepositoryPort.deleteById(member.getId());
    }
}
