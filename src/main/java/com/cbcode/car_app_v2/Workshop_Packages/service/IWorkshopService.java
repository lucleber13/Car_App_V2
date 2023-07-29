package com.cbcode.car_app_v2.Workshop_Packages.service;

import com.cbcode.car_app_v2.Workshop_Packages.model.DTO.WorkshopDto;

import java.util.List;

public interface IWorkshopService {
    WorkshopDto addCarToWorkshop(WorkshopDto workshopDto);
    WorkshopDto updateCarInWorkshop(WorkshopDto workshopDto);
    void deleteWorkshop(Long id);
    List<WorkshopDto> getAllCarsInWorkshops();
    WorkshopDto getCarInWorkshopById(Long id);
    WorkshopDto getCarByRegNumber(String regNumber);
    WorkshopDto startsJobWorkshop(WorkshopDto workshopDto);
    WorkshopDto finishingJobWorkshop(WorkshopDto workshopDto);

}
