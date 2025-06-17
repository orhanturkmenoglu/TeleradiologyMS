package com.teleradms.member.service.application.port.output;

import com.teleradms.member.service.domain.entities.Member;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepositoryPort {

    Member save(Member member);

    Optional<Member> findById(UUID uuid);

    List<Member> findAll();

    boolean existsByPhone(String phoneNumber);

    void deleteById(UUID uuid);
}
