package com.cbcode.car_app_v2.Workshop_Packages.controller;

import com.cbcode.car_app_v2.Workshop_Packages.model.DTO.WorkshopCompletedDto;
import com.cbcode.car_app_v2.Workshop_Packages.model.DTO.WorkshopDto;
import com.cbcode.car_app_v2.Workshop_Packages.service.impl.WorkshopCompletedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workshop-completed")
public class WorkshopCompletedController {
    private final WorkshopCompletedService workshopCompletedService;

    public WorkshopCompletedController(WorkshopCompletedService workshopCompletedService) {
        this.workshopCompletedService = workshopCompletedService;
    }

    @RequestMapping("/all-workshop-completed")
    public ResponseEntity<List<WorkshopCompletedDto>> getAllWorkshopCompleted(){
        return ResponseEntity.ok().body(workshopCompletedService.getAllWorkshopCompleted());
    }

    @RequestMapping("/workshop-completed/{regNumber}")
    public ResponseEntity<List<WorkshopCompletedDto>> getWorkshopCompleted(@PathVariable(value="regNumber") String regNumber){
        return ResponseEntity.ok().body(workshopCompletedService.getWorkshopCompletedByRegNumber(regNumber));
    }
}
