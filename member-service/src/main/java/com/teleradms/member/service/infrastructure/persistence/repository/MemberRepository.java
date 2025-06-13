package com.teleradms.member.service.infrastructure.persistence.repository;

import com.teleradms.member.service.infrastructure.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberEntity, UUID> {

    List<MemberEntity> findAllByIsActiveFalse();

    boolean existsByPhone(String phoneNumber);
}
