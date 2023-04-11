package com.cbcode.car_app_v2.Workshop_Packages.service;

import com.cbcode.car_app_v2.Workshop_Packages.model.DTO.WorkshopDto;

import java.util.List;

public interface IWorkshopService {
    WorkshopDto addWorkshop(WorkshopDto workshopDto);
    WorkshopDto updateWorkshop(WorkshopDto workshopDto);
    void deleteWorkshop(Long id);
    List<WorkshopDto> getAllWorkshops();
    WorkshopDto getWorkshopById(Long id);
    WorkshopDto getCarByRegNumber(String regNumber);
    WorkshopDto startsWorkshop(WorkshopDto workshopDto);
    WorkshopDto finishingWorkshop(WorkshopDto workshopDto);

}
