package com.cbcode.car_app_v2.Workshop_Packages.service.impl;

import com.cbcode.car_app_v2.Exceptions.CarAlreadyExistsException;
import com.cbcode.car_app_v2.Exceptions.WorkshopNotCreatedException;
import com.cbcode.car_app_v2.Workshop_Packages.model.DTO.WorkshopDto;
import com.cbcode.car_app_v2.Workshop_Packages.model.Workshop;
import com.cbcode.car_app_v2.Workshop_Packages.repository.WorkshopRepository;
import com.cbcode.car_app_v2.Workshop_Packages.service.IWorkshopService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkshopService implements IWorkshopService {
    private final WorkshopRepository workshopRepository;
    private final ModelMapper modelMapper;

    public WorkshopService(WorkshopRepository workshopRepository, ModelMapper modelMapper) {
        this.workshopRepository = workshopRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @param workshopDto
     * @return
     */
    @Override
    public WorkshopDto addWorkshop(WorkshopDto workshopDto) {
        try {
            Workshop workshop = modelMapper.map(workshopDto, Workshop.class);
            Optional<Workshop> optionalWorkshop = workshopRepository.findWorkshopByRegNumberIgnoreCase(workshop.getRegNumber());
            if (optionalWorkshop.isPresent()) {
                throw new CarAlreadyExistsException("Car with registration number " + workshopDto.getRegNumber() + " already exists!");
            } else {
                Workshop savedWorkshop = workshopRepository.save(workshop);
                return modelMapper.map(savedWorkshop, WorkshopDto.class);
            }
        } catch (Exception e) {
            throw new WorkshopNotCreatedException("Workshop not created! " + e.getMessage());
        }
    }

    /**
     * @param workshopDto
     * @return
     */
    @Override
    public WorkshopDto updateWorkshop(WorkshopDto workshopDto) {
        try {
            Optional<Workshop> optionalWorkshop = workshopRepository.findById(workshopDto.getId());
            if (!optionalWorkshop.isPresent()) {
                throw new EntityNotFoundException("Workshop with id " + workshopDto.getId() + " not found!");
            }
            Workshop workshop = modelMapper.map(workshopDto, Workshop.class);
            workshop.setId(optionalWorkshop.get().getId());
            Workshop savedWorkshop = workshopRepository.save(workshop);
            WorkshopDto savedWorkshopDto = modelMapper.map(savedWorkshop, WorkshopDto.class);
            return savedWorkshopDto;
        } catch (Exception e) {
            throw new WorkshopNotCreatedException("Workshop not updated! " + e.getMessage());
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteWorkshop(Long id) {

    }

    /**
     * @return
     */
    @Override
    public List<WorkshopDto> getAllWorkshops() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public WorkshopDto getWorkshopById(Long id) {
        return null;
    }

    /**
     * @param regNumber
     * @return
     */
    @Override
    public WorkshopDto getCarByRegNumber(String regNumber) {
        return null;
    }

    /**
     * @param workshopDto
     * @return
     */
    @Override
    public WorkshopDto startsWorkshop(WorkshopDto workshopDto) {
        return null;
    }

    /**
     * @param workshopDto
     * @return
     */
    @Override
    public WorkshopDto finishingWorkshop(WorkshopDto workshopDto) {
        return null;
    }
}
