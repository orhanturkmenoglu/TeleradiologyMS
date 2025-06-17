package com.teleradms.hospital.service.infrastructure.persistence.repository;

import com.teleradms.hospital.service.infrastructure.persistence.entities.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HospitalJpaRepository extends JpaRepository<HospitalEntity, UUID> {

    List<HospitalEntity> findByIsActiveTrue();

    List<HospitalEntity> findByCityIgnoreCase(String city);

    // İsme göre (shortName veya fullTitle içinde geçen)
    List<HospitalEntity> findByShortNameContainingIgnoreCaseOrFullTitleContainingIgnoreCase(String shortName, String fullTitle);

    List<HospitalEntity> findByIsDeletedTrue();

    Optional<HospitalEntity> findByTaxNumber(String taxNumber);

}