package com.cbcode.car_app_v2.JobForms_Packages.service;

import com.cbcode.car_app_v2.JobForms_Packages.model.DTO.JobFormsDto;
import com.cbcode.car_app_v2.JobForms_Packages.model.JobForms;

import java.util.List;

public interface IJobFormsService {

    JobForms addJobCreation(JobFormsDto jobFormsDto);
    JobForms updateJobCreation(JobFormsDto jobFormsDto);
    List<JobForms> findAllJobCreations();
    void deleteJobCreation(Long id);
    JobForms findJobCreationById(Long id);
    JobForms findJobCreationByUser_id(Long user_id);
    JobForms findJobCreationByReg_number(String reg_number);
    JobForms findJobCreationByChassis_number(String chassis_number);
    JobForms findJobCreationByModel(String model);
}
