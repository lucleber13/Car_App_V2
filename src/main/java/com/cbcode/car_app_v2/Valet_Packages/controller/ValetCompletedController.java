package com.cbcode.car_app_v2.Valet_Packages.controller;

import com.cbcode.car_app_v2.Valet_Packages.model.DTO.ValetCompletedDto;
import com.cbcode.car_app_v2.Valet_Packages.service.impl.ValetCompletedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/valet-completed")
public class ValetCompletedController {

    private final ValetCompletedService valetCompletedService;

    public ValetCompletedController(ValetCompletedService valetCompletedService) {
        this.valetCompletedService = valetCompletedService;
    }

    @GetMapping("/all-valets-completed")
    public ResponseEntity<List<ValetCompletedDto>> getAllValetsCompleted(){
        return ResponseEntity.ok().body(valetCompletedService.getAllValetsCompleted());
    }
    @GetMapping("/valet-completed")
    public ResponseEntity<List<ValetCompletedDto>> getValetCompleted(String regNumber){
        return ResponseEntity.ok().body(valetCompletedService.getValetedByRegNumber(regNumber));
    }

}
