package com.teleradms.hospital.service.infrastructure.persistence.entities;

import com.teleradms.common.lib.base.BaseEntity;

import com.teleradms.hospital.service.domain.enums.Modality;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "HospitalUserPartitions")
@Getter
@Setter
@NoArgsConstructor
public class HospitalUserPartitionEntity extends BaseEntity {

    @Column(name = "UserId", nullable = false)
    private UUID userId;

    @Column(name = "CompanyId", nullable = false)
    private UUID companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PartitionId", nullable = false)
    private PartitionEntity partition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HospitalId", nullable = false)
    private HospitalEntity hospital;

    @Column(name = "IsUrgent", nullable = false)
    private Boolean urgent;

    @Enumerated(EnumType.STRING)
    @Column(name = "ModalityType", length = 20)
    private Modality modalityType;

    @Column(name = "ReferenceKey", length = 255)
    private String referenceKey;

    @Column(name = "PartitionCode", length = 50)
    private String partitionCode;

    @Column(name = "CompanyCode", length = 50)
    private String companyCode;
}
