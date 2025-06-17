package com.teleradms.hospital.service.infrastructure.persistence.entities;


import com.teleradms.common.lib.base.BaseEntity;
import com.teleradms.hospital.service.domain.enums.Modality;
import com.teleradms.hospital.service.domain.enums.PartitionType;
import com.teleradms.hospital.service.domain.enums.UrgentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Partitions")
@Getter
@Setter
@NoArgsConstructor
public class PartitionEntity extends BaseEntity {

    @Column(name = "CompanyId", nullable = false)
    private UUID companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HospitalId", nullable = false)
    private HospitalEntity hospital;

    @Enumerated(EnumType.STRING)
    @Column(name = "PartitionType", nullable = false, length = 50)
    private PartitionType partitionType;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "UrgentStatus", nullable = false, length = 20)
    private UrgentStatus urgentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "ModalityType", length = 20)
    private Modality modalityType;

    @Column(name = "PartitionsCode", length = 50)
    private String partitionsCode;

    @Column(name = "ReferenceKey", length = 255)
    private String referenceKey;
}