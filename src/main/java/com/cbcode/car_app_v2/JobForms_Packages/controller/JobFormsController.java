package com.cbcode.car_app_v2.JobForms_Packages.controller;

import com.cbcode.car_app_v2.JobForms_Packages.model.DTO.JobFormsDto;
import com.cbcode.car_app_v2.JobForms_Packages.model.JobForms;
import com.cbcode.car_app_v2.JobForms_Packages.service.impl.JobFormsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-creation")
public class JobFormsController {
    private final JobFormsService jobCreationService;

    public JobFormsController(JobFormsService jobCreationService) {
        this.jobCreationService = jobCreationService;
    }
    @PostMapping("/add-job-creation")
    public ResponseEntity<JobForms> addJobCreation(@RequestBody JobFormsDto jobFormsDto){
        return ResponseEntity.ok(jobCreationService.addJobCreation(jobFormsDto));
    }
}
