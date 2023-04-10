package com.cbcode.car_app_v2.JobForms_Packages.service.impl;

import com.cbcode.car_app_v2.Car_Package.repository.CarRepository;
import com.cbcode.car_app_v2.JobForms_Packages.model.DTO.JobFormsDto;
import com.cbcode.car_app_v2.JobForms_Packages.model.JobForms;
import com.cbcode.car_app_v2.JobForms_Packages.repository.JobFormsRepository;
import com.cbcode.car_app_v2.JobForms_Packages.service.IJobFormsService;
import com.cbcode.car_app_v2.Sales_Packages.service.impl.SalesService;
import com.cbcode.car_app_v2.Valet_Packages.service.impl.ValetService;
import com.cbcode.car_app_v2.Workshop_Packages.service.impl.WorkshopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobFormsService implements IJobFormsService {
    private final JobFormsRepository jobFormsRepository;
    private final ModelMapper modelMapper;
    private final SalesService salesService;
    private final WorkshopService workshopService;
    private final ValetService valetService;

    public JobFormsService(JobFormsRepository jobFormsRepository, ModelMapper modelMapper,
                           SalesService salesService, WorkshopService workshopService, ValetService valetService) {
        this.jobFormsRepository = jobFormsRepository;
        this.modelMapper = modelMapper;
        this.salesService = salesService;
        this.workshopService = workshopService;
        this.valetService = valetService;
    }

    /**
     * @param jobFormsDto
     * @return
     */
    @Override
    public JobForms addJobCreation(JobFormsDto jobFormsDto) {
        // Map the DTO to the entity
        JobForms jobForms = modelMapper.map(jobFormsDto, JobForms.class);

        // Save the entity to the repository
        JobForms savedJobForms = jobFormsRepository.save(jobForms);
        // Return the saved entity
        return savedJobForms;
    }

    /**
     * @param jobFormsDto
     * @return
     */
    @Override
    public JobForms updateJobCreation(JobFormsDto jobFormsDto) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<JobForms> findAllJobCreations() {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteJobCreation(Long id) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public JobForms findJobCreationById(Long id) {
        return null;
    }

    /**
     * @param user_id
     * @return
     */
    @Override
    public JobForms findJobCreationByUser_id(Long user_id) {
        return null;
    }

    /**
     * @param reg_number
     * @return
     */
    @Override
    public JobForms findJobCreationByReg_number(String reg_number) {
        return null;
    }

    /**
     * @param chassis_number
     * @return
     */
    @Override
    public JobForms findJobCreationByChassis_number(String chassis_number) {
        return null;
    }

    /**
     * @param model
     * @return
     */
    @Override
    public JobForms findJobCreationByModel(String model) {
        return null;
    }
}
