package com.cbcode.car_app_v2.JobForms_Packages.service;

import com.cbcode.car_app_v2.JobForms_Packages.model.DTO.JobFormsDto;
import com.cbcode.car_app_v2.JobForms_Packages.model.JobForms;

public interface IJobFormsService {

    JobForms createJobForm(JobFormsDto jobFormsDto);
    JobForms updateJobForm(JobFormsDto jobFormsDto);

}
