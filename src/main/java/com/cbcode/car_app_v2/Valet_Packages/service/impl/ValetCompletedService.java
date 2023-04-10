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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValetCompletedService {
    private final ValetCompletedRepository valetCompletedRepository;
    private final ModelMapper modelMapper;

    public ValetCompletedService(ValetCompletedRepository valetCompletedRepository, ModelMapper modelMapper) {
        this.valetCompletedRepository = valetCompletedRepository;
        this.modelMapper = modelMapper;
    }
    // This method will be called from the ValetService class when the valet is finished.
    // Then, this method will save the object in this database using the ValetCompletedRepository.
    public ValetCompletedDto addValetCompleted(ValetCompletedDto valetCompletedDto) {
        ValetCompleted valetCompleted = modelMapper.map(valetCompletedDto, ValetCompleted.class);
        ValetCompleted savedValetCompleted = valetCompletedRepository.save(valetCompleted);
        return modelMapper.map(savedValetCompleted, ValetCompletedDto.class);
    }

    public List<ValetCompletedDto> getAllValetsCompleted() {
        ValetCompleted valetCompleted = modelMapper.map(valetCompletedRepository.findAll(), ValetCompleted.class);
        if (valetCompleted == null) {
            throw new CarNotFoundException("No valets completed yet.");
        } else {
            List<ValetCompleted> valetCompletedList = valetCompletedRepository.findAll();
            List<ValetCompletedDto> valetCompletedDtoList = new ArrayList<>();
            valetCompletedDtoList = valetCompletedList.stream()
                    .map(allValetsCompleted -> modelMapper.map(allValetsCompleted, ValetCompletedDto.class))
                    .collect(Collectors.toList());
            return valetCompletedDtoList;
        }
    }

    @Transactional
    @Modifying
    @Scheduled(cron = "0 0 0 * * *") // This method will run every day at midnight.
    @Query("DELETE FROM ValetCompleted v WHERE v.dateCreated < :dateThreshold")
    public void deleteValetCompleted() {
           LocalDateTime dateThreshold = LocalDateTime.now().minusDays(61);
            valetCompletedRepository.deleteValetCompletedByDateCreatedBefore(dateThreshold);
    }

}
