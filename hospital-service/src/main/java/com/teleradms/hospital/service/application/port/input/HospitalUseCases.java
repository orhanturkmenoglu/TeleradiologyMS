package com.teleradms.hospital.service.application.port.input;

import com.teleradms.hospital.service.application.dto.request.HospitalRequest;
import com.teleradms.hospital.service.application.dto.response.HospitalResponse;

import java.util.List;
import java.util.UUID;
public interface HospitalUseCases {

    HospitalResponse createHospital(HospitalRequest hospitalRequest); // yeni kayıt

    void deleteHospitalById(UUID id);

    HospitalResponse getHospitalById(UUID id);

    List<HospitalResponse> getAllHospitals();

    List<HospitalResponse> getActiveHospitals();

    List<HospitalResponse> getHospitalsByCity(String city);

    List<HospitalResponse> searchHospitalsByName(String name);

    List<HospitalResponse> getDeletedHospitals();
    HospitalResponse getHospitalByTaxNumber(String taxNumber);
}
