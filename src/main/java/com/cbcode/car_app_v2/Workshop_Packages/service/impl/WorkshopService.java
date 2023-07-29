package com.cbcode.car_app_v2.Workshop_Packages.service.impl;

import com.cbcode.car_app_v2.Enums.JobStatus;
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
import java.util.stream.Collectors;

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
    public WorkshopDto addCarToWorkshop(WorkshopDto workshopDto) {
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
    public WorkshopDto updateCarInWorkshop(WorkshopDto workshopDto) {
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
        try {
            Optional<Workshop> optionalWorkshop = workshopRepository.findById(id);
            if (!optionalWorkshop.isPresent()) {
                throw new EntityNotFoundException("Workshop with id " + id + " not found!");
            }
            workshopRepository.deleteById(id);
        } catch (Exception e) {
            throw new WorkshopNotCreatedException("Workshop not deleted! " + e.getMessage());
        }
    }

    /**
     * @return List<WorkshopDto> of all workshops
     * @throws EntityNotFoundException if no workshops are found
     * Get all cars in workshop as a list of cars.
     */
    @Override
    public List<WorkshopDto> getAllCarsInWorkshops() {
        try {
            Workshop workshop = modelMapper.map(workshopRepository.findAll(), Workshop.class);
            if (workshop == null) {
                throw new EntityNotFoundException("Workshop Car not found!");
            }
            List<Workshop> workshops = workshopRepository.findAll();
            List<Workshop> workshopList = workshops.stream()
                    .map(workshop1 -> modelMapper.map(workshop1, Workshop.class))
                    .collect(Collectors.toList());
            List workshopDtos = modelMapper.map(workshopList, List.class);
            return workshopDtos;
        } catch (Exception e) {
            throw new IllegalArgumentException("Car in Workshop not found! " + e.getMessage());
        }
    }

    /**
     * @param id
     * @return WorkshopDto
     */
    @Override
    public WorkshopDto getCarInWorkshopById(Long id) {
        try {
            Optional<Workshop> optionalWorkshop = workshopRepository.findById(id);
            if (!optionalWorkshop.isPresent()) {
                throw new EntityNotFoundException("Workshop with id " + id + " not found!");
            }
            Workshop workshop = modelMapper.map(optionalWorkshop.get(), Workshop.class);
            WorkshopDto workshopDto = modelMapper.map(workshop, WorkshopDto.class);
            return workshopDto;
        } catch (Exception e) {
            throw new IllegalArgumentException("Workshop not found! " + e.getMessage());
        }
    }

    /**
     * @param regNumber
     * @return
     */
    @Override
    public WorkshopDto getCarByRegNumber(String regNumber) {
        try {
            Optional<Workshop> optionalWorkshop = workshopRepository.findWorkshopByRegNumberIgnoreCase(regNumber);
            if (!optionalWorkshop.isPresent()) {
                throw new EntityNotFoundException("Workshop with registration number " + regNumber + " not found!");
            }
            Workshop workshop = modelMapper.map(optionalWorkshop.get(), Workshop.class);
            WorkshopDto workshopDto = modelMapper.map(workshop, WorkshopDto.class);
            return workshopDto;
        } catch (Exception e) {
            throw new IllegalArgumentException("Workshop not found! " + e.getMessage());
        }
    }

    /**
     * @param workshopDto
     * @return
     */
    @Override
    public WorkshopDto startsJobWorkshop(WorkshopDto workshopDto) {
        Workshop workshop = modelMapper.map(workshopDto, Workshop.class);
        workshop.setJobStatus(JobStatus.STARTS);
        workshopRepository.save(workshop);
        return modelMapper.map(workshop, WorkshopDto.class);
    }

    /**
     * @param workshopDto
     * @return
     */
    @Override
    public WorkshopDto finishingJobWorkshop(WorkshopDto workshopDto) {
        return null;
    }
}
