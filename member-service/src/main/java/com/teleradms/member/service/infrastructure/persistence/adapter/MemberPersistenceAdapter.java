package com.teleradms.member.service.infrastructure.persistence.adapter;

import com.teleradms.member.service.application.port.output.MemberRepositoryPort;
import com.teleradms.member.service.domain.entities.Member;
import com.teleradms.member.service.infrastructure.persistence.entity.MemberEntity;
import com.teleradms.member.service.infrastructure.persistence.mapper.MemberEntityMapper;
import com.teleradms.member.service.infrastructure.persistence.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberPersistenceAdapter implements MemberRepositoryPort {

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        log.info("MemberPersistenceAdapter::save  Saving member: {}", member);

        MemberEntity savedMember = memberRepository.save(MemberEntityMapper.toEntity(member));
        return MemberEntityMapper.toDomain(savedMember);
    }

    @Override
    public Optional<Member> findById(UUID uuid) {
        log.info("MemberPersistenceAdapter::findById  Finding member by id: {}", uuid);

        return memberRepository.findById(uuid)
                .map(MemberEntityMapper::toDomain);
    }

    @Override
    public List<Member> findAll() {
        log.info("MemberPersistenceAdapter::findAll  Fetching all members");

        return memberRepository.findAll()
                .stream()
                .map(MemberEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID uuid) {
        log.info("MemberPersistenceAdapter::deleteById  Deleting member by id: {}", uuid);

        memberRepository.deleteById(uuid);
    }
}
