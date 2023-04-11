package com.cbcode.car_app_v2.Workshop_Packages.controller;

import com.cbcode.car_app_v2.Exceptions.WorkshopNotFoundException;
import com.cbcode.car_app_v2.Workshop_Packages.model.DTO.WorkshopDto;
import com.cbcode.car_app_v2.Workshop_Packages.service.impl.WorkshopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workshop")
public class WorkshopController {
    private final WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @PostMapping("/add")
    public ResponseEntity<WorkshopDto> addWorkshop(@RequestBody WorkshopDto workshopDto) {
        return ResponseEntity.ok().body(workshopService.addWorkshop(workshopDto));
    }
    @PutMapping("/update")
    public ResponseEntity<WorkshopDto> updateWorkshop(@RequestBody WorkshopDto workshopDto) {
        try {
            return ResponseEntity.ok().body(workshopService.updateWorkshop(workshopDto));
        } catch (Exception e) {
            throw new WorkshopNotFoundException("Workshop with ID " + workshopDto.getId() + " not found");
        }
    }
}
