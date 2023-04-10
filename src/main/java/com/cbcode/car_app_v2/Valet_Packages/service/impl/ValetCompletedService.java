package com.cbcode.car_app_v2.Valet_Packages.service.impl;

import com.cbcode.car_app_v2.Exceptions.CarNotFoundException;
import com.cbcode.car_app_v2.Valet_Packages.model.DTO.ValetCompletedDto;
import com.cbcode.car_app_v2.Valet_Packages.model.ValetCompleted;
import com.cbcode.car_app_v2.Valet_Packages.repository.ValetCompletedRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class will be used to add a valet completed to the database and to get all the valets completed.
 * It will also run a scheduled method that will delete all the valets completed that are older than 61 days.
 * It will use the ValetCompletedRepository class to interact with the database.
 * It will use the ModelMapper class to map the ValetCompletedDto to the ValetCompleted entity.
 * Author: Cleber Balbinote
 * Date: 10/04/2023
 */
@Service
public class ValetCompletedService {
    private final ValetCompletedRepository valetCompletedRepository;
    private final ModelMapper modelMapper;

    public ValetCompletedService(ValetCompletedRepository valetCompletedRepository, ModelMapper modelMapper) {
        this.valetCompletedRepository = valetCompletedRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * This method will be called from the ValetCompletedController class. It will add a valet completed to the database.
     * It will use the model mapper to map the valetCompletedDto to the ValetCompleted entity.
     * @param valetCompletedDto
     * @return ValetCompletedDto
     */
    public ValetCompletedDto addValetCompleted(ValetCompletedDto valetCompletedDto) {
        ValetCompleted valetCompleted = modelMapper.map(valetCompletedDto, ValetCompleted.class);
        ValetCompleted savedValetCompleted = valetCompletedRepository.save(valetCompleted);
        return modelMapper.map(savedValetCompleted, ValetCompletedDto.class);
    }

    /**
     * This method will be called from the ValetCompletedController class. It will return a list of all the valets completed.
     * @return List<ValetCompletedDto>
     */
    public List<ValetCompletedDto> getAllValetsCompleted() {
        ValetCompleted valetCompleted = modelMapper.map(valetCompletedRepository.findAll(), ValetCompleted.class);
        if (valetCompleted == null) {
            throw new CarNotFoundException("No valets completed yet.");
        } else {
            List<ValetCompleted> valetCompletedList = valetCompletedRepository.findAll();
            List<ValetCompletedDto> valetCompletedDtoList;
            valetCompletedDtoList = valetCompletedList.stream()
                    .map(allValetsCompleted -> modelMapper.map(allValetsCompleted, ValetCompletedDto.class))
                    .collect(Collectors.toList());
            return valetCompletedDtoList;
        }
    }

    /**
     * This method will run every day at midnight. It will delete all the valets completed that are older than 61 days.
     * This is done to keep the database clean.
     */
    @Transactional
    @Modifying
    @Scheduled(cron = "0 0 0 * * *") // This method will run every day at midnight.
    @Query("DELETE FROM ValetCompleted v WHERE v.dateCreated < :dateThreshold")
    public void deleteValetCompleted() {
           LocalDateTime dateThreshold = LocalDateTime.now().minusDays(61);
            valetCompletedRepository.deleteValetCompletedByDateCreatedBefore(dateThreshold);
    }

}
