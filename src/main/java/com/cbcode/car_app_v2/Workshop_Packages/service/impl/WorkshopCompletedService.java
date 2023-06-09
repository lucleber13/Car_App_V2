package com.cbcode.car_app_v2.Workshop_Packages.service.impl;

import com.cbcode.car_app_v2.Exceptions.CarNotFoundException;
import com.cbcode.car_app_v2.Workshop_Packages.model.DTO.WorkshopCompletedDto;
import com.cbcode.car_app_v2.Workshop_Packages.model.WorkshopCompleted;
import com.cbcode.car_app_v2.Workshop_Packages.repository.WorkshopCompletedRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkshopCompletedService {
    private final WorkshopCompletedRepository workshopCompletedRepository;
    private final ModelMapper modelMapper;

    public WorkshopCompletedService(WorkshopCompletedRepository workshopCompletedRepository, ModelMapper modelMapper) {
        this.workshopCompletedRepository = workshopCompletedRepository;
        this.modelMapper = modelMapper;
    }
    /**
     * This method will be called from the WorkshopCompletedController class.
     * It will add a workshop completed to the database.
     * It will use the model mapper to map the workshopCompletedDto to the WorkshopCompleted entity.
     * @return WorkshopCompletedDto
     */
    public WorkshopCompletedDto addWorkshopCompleted(WorkshopCompletedDto workshopCompletedDto) {
        WorkshopCompleted workshopCompleted = modelMapper.map(workshopCompletedDto, WorkshopCompleted.class);
        WorkshopCompleted savedWorkshopCompleted = workshopCompletedRepository.save(workshopCompleted);
        return modelMapper.map(savedWorkshopCompleted, WorkshopCompletedDto.class);
    }
    /**
     * This method will be called from the WorkshopCompletedController class.
     * It will return a list of all the workshop completed.
     * @return List<WorkshopCompletedDto>
     */
    public List<WorkshopCompletedDto> getAllWorkshopCompleted() {
        WorkshopCompleted workshopCompleted = modelMapper.map(workshopCompletedRepository.findAll(), WorkshopCompleted.class);
        if (workshopCompleted == null) {
            throw new CarNotFoundException("No workshop completed yet.");
        } else {
            List<WorkshopCompleted> workshopCompletedList = workshopCompletedRepository.findAll();
            List<WorkshopCompletedDto> workshopCompletedDtoList;
            workshopCompletedDtoList = workshopCompletedList.stream()
                    .map(allWorkshopCompleted -> modelMapper.map(allWorkshopCompleted, WorkshopCompletedDto.class))
                    .collect(Collectors.toList());
            return workshopCompletedDtoList;
        }
    }

    /**
     * This method will run every day at midnight. It will delete all the valets completed that are older than 61 days.
     * This is done to keep the database clean.
     */
    @Transactional
    @Modifying
    @Scheduled(cron = "0 0 0 * * *") // This method will run every day at midnight.
    @Query("DELETE FROM WorkshopCompleted v WHERE v.dateCreated < :dateThreshold")
    public void deleteWorkshopCompleted() {
        LocalDateTime dateThreshold = LocalDateTime.now().minusDays(61);
        workshopCompletedRepository.deleteWorkshopCompletedByDateCreatedBefore(dateThreshold);
    }

    public List<WorkshopCompletedDto> getWorkshopCompletedByRegNumber(String regNumber) {
        Optional<WorkshopCompleted> workshopCompleted = workshopCompletedRepository.findWorkshopCompletedByRegNumberIgnoreCase(regNumber);
        if (!workshopCompleted.isPresent()) {
            throw new CarNotFoundException("No workshop completed yet.");
        } else {
            WorkshopCompletedDto workshopCompletedDto = modelMapper.map(workshopCompleted.get(), WorkshopCompletedDto.class);
            return List.of(workshopCompletedDto);
        }
    }
}
