package com.teleradms.hospital.service.domain.model;


import com.teleradms.common.lib.base.BaseDomain;
import com.teleradms.hospital.service.domain.enums.Modality;
import com.teleradms.hospital.service.domain.enums.PartitionType;
import com.teleradms.hospital.service.domain.enums.UrgentStatus;

import java.util.UUID;

public class Partition extends BaseDomain {

    private UUID companyId;
    private Hospital hospital;
    private PartitionType partitionType;
    private Boolean isActive;
    private UrgentStatus urgentStatus;
    private Modality modalityType;
    private String partitionsCode;
    private String referenceKey;

    public Partition() {
    }

    public Partition(UUID companyId, Hospital hospital, PartitionType partitionType, Boolean isActive,
                     UrgentStatus urgentStatus, Modality modalityType, String partitionsCode, String referenceKey) {
        this.companyId = companyId;
        this.hospital = hospital;
        this.partitionType = partitionType;
        this.isActive = isActive;
        this.urgentStatus = urgentStatus;
        this.modalityType = modalityType;
        this.partitionsCode = partitionsCode;
        this.referenceKey = referenceKey;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public PartitionType getPartitionType() {
        return partitionType;
    }

    public void setPartitionType(PartitionType partitionType) {
        this.partitionType = partitionType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public UrgentStatus getUrgentStatus() {
        return urgentStatus;
    }

    public void setUrgentStatus(UrgentStatus urgentStatus) {
        this.urgentStatus = urgentStatus;
    }

    public Modality getModalityType() {
        return modalityType;
    }

    public void setModalityType(Modality modalityType) {
        this.modalityType = modalityType;
    }

    public String getPartitionsCode() {
        return partitionsCode;
    }

    public void setPartitionsCode(String partitionsCode) {
        this.partitionsCode = partitionsCode;
    }

    public String getReferenceKey() {
        return referenceKey;
    }

    public void setReferenceKey(String referenceKey) {
        this.referenceKey = referenceKey;
    }
}
