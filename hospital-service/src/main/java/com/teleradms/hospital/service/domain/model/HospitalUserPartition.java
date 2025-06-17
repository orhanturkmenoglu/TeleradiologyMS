package com.teleradms.hospital.service.domain.model;

import com.teleradms.common.lib.base.BaseDomain;
import com.teleradms.hospital.service.domain.enums.Modality;

import java.util.UUID;


public class HospitalUserPartition extends BaseDomain {

    private UUID userId;
    private UUID companyId;
    private Partition partition;
    private Hospital hospital;


    private Boolean urgent;
    private Modality modalityType;
    private String referenceKey;
    private String partitionCode;
    private String companyCode;


    public HospitalUserPartition() {
    }

    public HospitalUserPartition(UUID userId, Partition partition, Hospital hospital, Boolean urgent,
                                 Modality modalityType, String referenceKey, String partitionCode,
                                 String companyCode, UUID companyId) {
        this.userId = userId;
        this.partition = partition;
        this.hospital = hospital;
        this.urgent = urgent;
        this.modalityType = modalityType;
        this.referenceKey = referenceKey;
        this.partitionCode = partitionCode;
        this.companyCode = companyCode;
        this.companyId = companyId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Partition getPartition() {
        return partition;
    }

    public void setPartition(Partition partition) {
        this.partition = partition;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
    }

    public Modality getModalityType() {
        return modalityType;
    }

    public void setModalityType(Modality modalityType) {
        this.modalityType = modalityType;
    }

    public String getReferenceKey() {
        return referenceKey;
    }

    public void setReferenceKey(String referenceKey) {
        this.referenceKey = referenceKey;
    }

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }


}
