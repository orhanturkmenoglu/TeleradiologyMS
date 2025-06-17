package com.teleradms.hospital.service.application.port.input;


import com.teleradms.hospital.service.application.dto.request.HospitalUserPartitionRequest;
import com.teleradms.hospital.service.application.dto.response.HospitalUserPartitionResponse;

import java.util.List;
import java.util.UUID;

public interface HospitalUserPartitionUseCases {

    HospitalUserPartitionResponse createHospitalUserPartition(HospitalUserPartitionRequest request);

    HospitalUserPartitionResponse getHospitalUserPartitionById(UUID id);

    List<HospitalUserPartitionResponse> getAllByUserId(UUID userId);

    List<HospitalUserPartitionResponse> getAllByCompanyId(UUID companyId);

    List<HospitalUserPartitionResponse> getAllByPartitionCode(String partitionCode);

    void deleteHospitalUserPartitionById(UUID id);

    boolean existsByUserIdAndPartitionCode(UUID userId, String partitionCode);
}
