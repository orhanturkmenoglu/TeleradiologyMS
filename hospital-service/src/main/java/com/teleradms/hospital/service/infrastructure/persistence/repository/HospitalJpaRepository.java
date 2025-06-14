package com.teleradms.hospital.service.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospitalJpaRepository extends JpaRepository<HospitalJpaRepository, UUID> {

}
