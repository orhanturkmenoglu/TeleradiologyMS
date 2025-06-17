package com.teleradms.company.service.infrustructure.persistance.repository;

import com.teleradms.company.service.infrustructure.persistance.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
}
