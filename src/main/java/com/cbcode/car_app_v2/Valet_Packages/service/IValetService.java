package com.cbcode.car_app_v2.Valet_Packages.service;

import com.cbcode.car_app_v2.Valet_Packages.model.DTO.ValetDto;

import java.util.List;

public interface IValetService {
    ValetDto addValet(ValetDto savedValetDto);
    ValetDto updateValet(ValetDto valetDto);
    void deleteValet(Long id);
    List<ValetDto> getAllValets();
    ValetDto getValetById(Long id);
    ValetDto getCarByRegNumber(String regNumber);
    ValetDto startsValet(ValetDto valetDto);
    ValetDto finishingValet(ValetDto valetDto);
}
