package com.cbcode.car_app_v2.JobForms_Packages.controller;

import com.cbcode.car_app_v2.JobForms_Packages.model.DTO.JobFormsDto;
import com.cbcode.car_app_v2.JobForms_Packages.model.JobForms;
import com.cbcode.car_app_v2.JobForms_Packages.service.impl.JobFormsService;
import com.cbcode.car_app_v2.Sales_Packages.service.impl.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobForms")
public class JobFormsController {
    private final JobFormsService jobCreationService;

    public JobFormsController(JobFormsService jobCreationService) {
        this.jobCreationService = jobCreationService;
    }
    @PostMapping("/add")
    public ResponseEntity<JobForms> addJobForms(@RequestBody JobFormsDto jobFormsDto){
        return ResponseEntity.ok(jobCreationService.createJobForm(jobFormsDto));
    }
}
