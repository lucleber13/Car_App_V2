package com.cbcode.car_app_v2.JobForms_Packages.service.impl;

import com.cbcode.car_app_v2.Car_Package.repository.CarRepository;
import com.cbcode.car_app_v2.JobForms_Packages.model.DTO.JobFormsDto;
import com.cbcode.car_app_v2.JobForms_Packages.model.JobForms;
import com.cbcode.car_app_v2.JobForms_Packages.repository.JobFormsRepository;
import com.cbcode.car_app_v2.JobForms_Packages.service.IJobFormsService;
import com.cbcode.car_app_v2.Sales_Packages.model.DTO.SalesDto;
import com.cbcode.car_app_v2.Sales_Packages.model.Sales;
import com.cbcode.car_app_v2.Sales_Packages.service.impl.SalesService;
import com.cbcode.car_app_v2.User_Packages.model.User;
import com.cbcode.car_app_v2.Valet_Packages.service.impl.ValetService;
import com.cbcode.car_app_v2.Workshop_Packages.service.impl.WorkshopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public JobForms createJobForm(JobFormsDto jobFormsDto) {
        // Map the DTO to the entity
        JobForms jobForms = modelMapper.map(jobFormsDto, JobForms.class);

        // Check if the car already exists
        Optional<JobForms> jobFormsOptional = jobFormsRepository.findJobCreationByRegNumberIgnoreCase(jobFormsDto.getRegNumber());
        if (jobFormsOptional.isPresent()) {
            throw new IllegalStateException("Car with registration number " + jobFormsDto.getRegNumber() + " already exists.");
        }




        // Save the entity to the repository
        JobForms savedJobForms = jobFormsRepository.save(jobForms);



        // Map the entity to the DTO
        SalesDto salesDto = modelMapper.map(jobFormsDto, SalesDto.class);
        salesService.addSales(salesDto);


        // Return the saved entity
        return savedJobForms;
    }

    /**
     * @param jobFormsDto
     * @return
     */
    @Override
    public JobForms updateJobForm(JobFormsDto jobFormsDto) {
        return null;
    }

}
