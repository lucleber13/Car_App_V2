package com.cbcode.car_app_v2.Valet_Packages.service.impl;

import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.Exceptions.CarAlreadyExistsException;
import com.cbcode.car_app_v2.Exceptions.ValetNotSavedException;
import com.cbcode.car_app_v2.Valet_Packages.model.DTO.ValetCompletedDto;
import com.cbcode.car_app_v2.Valet_Packages.model.DTO.ValetDto;
import com.cbcode.car_app_v2.Valet_Packages.model.Valet;
import com.cbcode.car_app_v2.Valet_Packages.model.ValetCompleted;
import com.cbcode.car_app_v2.Valet_Packages.repository.ValetCompletedRepository;
import com.cbcode.car_app_v2.Valet_Packages.repository.ValetRepository;
import com.cbcode.car_app_v2.Valet_Packages.service.IValetService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ValetService implements IValetService {
    private final ValetRepository valetRepository;
    private final ValetCompletedService valetCompletedService;
    private final ModelMapper modelMapper;

    public ValetService(ValetRepository valetRepository, ModelMapper modelMapper,  ValetCompletedService valetCompletedService) {
        this.valetRepository = valetRepository;
        this.modelMapper = modelMapper;
        this.valetCompletedService = valetCompletedService;
    }

    /**
     * @param savedValetDto
     * In this method we are adding a new valet job to the database. We are using the model mapper to map the valetDto to the Valet entity.
     * We are then saving the valet to the database and returning the valetDto.
     * This method is called from the JobForms class. Then the valetDto is added to the JobFormsDto.
     * The JobFormsDto is then passed to the JobFormsService class where it is saved to the database.
     */
    @Override
    public ValetDto addValet(ValetDto savedValetDto) {
        try {
            Valet valet = modelMapper.map(savedValetDto, Valet.class);
            Optional<Valet> optionalValet = valetRepository.findValetByRegNumberIgnoreCase(valet.getRegNumber().toUpperCase());
            if (optionalValet.isPresent()) {
                throw new CarAlreadyExistsException("Car with registration number " + savedValetDto.getRegNumber() + " already exists!");
            } else {
                Valet savedValet = valetRepository.save(valet);

                return modelMapper.map(savedValet, ValetDto.class);
            }
        } catch (Exception e) {
            throw new ValetNotSavedException("Valet not created! " + e.getMessage());
        }

    }

    /**
     * @param valetDto
     * @return ValetDto updatedValetDto This method is used to update a valet job. We are using the model mapper to map the valetDto to the Valet entity.
     * We are then saving the valet to the database and returning the valetDto.
     */
    @Override
    public ValetDto updateValet(ValetDto valetDto) {
        try {
            Optional<Valet> optionalValet = valetRepository.findById(valetDto.getId());

            if (!optionalValet.isPresent()) {
                throw new EntityNotFoundException("Valet not found with ID: " + valetDto.getId());
            }

            Valet valet = modelMapper.map(valetDto, Valet.class);
            valet.setId(optionalValet.get().getId());

            Valet updatedValet = valetRepository.save(valet);

            ValetDto updatedValetDto = modelMapper.map(updatedValet, ValetDto.class);

            return updatedValetDto;
        } catch (Exception e) {
            throw new ValetNotSavedException("Valet not updated! " + e.getMessage());
        }

    }

    /**
     * @param id
     * This method is used to delete a valet job. We are using the valetRepository to find the valet by id.
     * If the valet is not found we throw an exception.
     * If the valet is found we delete the valet from the database.
     */
    @Override
    public void deleteValet(Long id) {
        try {
            Optional<Valet> optionalValet = valetRepository.findById(id);

            if (!optionalValet.isPresent()) {
                throw new EntityNotFoundException("Valet not found with ID: " + id);
            }
            valetRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Valet not deleted! " + e.getMessage());
        }
    }

    /**
     * @return List<ValetDto> valetDtos
     * This method is used to get all valet jobs. We are using the valetRepository to get all valets.
     */
    @Override
    public List<ValetDto> getAllValets() {
        try {
            Valet valet = modelMapper.map(valetRepository.findAll(), Valet.class);
            if (valet == null) {
                throw new EntityNotFoundException("Valet not found");
            } else {
                List<Valet> valets = valetRepository.findAll();
                List<Valet> valetNewList = new ArrayList<>();
                valetNewList = valets.stream()
                        .map(valet1 ->
                                modelMapper.map(valet1, Valet.class))
                        .collect(Collectors.toList());
                List valetDtos = modelMapper.map(valetNewList, List.class);
                return valetDtos;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Valets not found! " + e.getMessage());
        }
    }

    /**
     * @param id
     * @return valetDto
     * This method is used to get a valet job by id. We are using the valetRepository to get the valet by id.
     * If the valet is not found we throw an exception.
     * If the valet is found we return the valetDto.
     */
    @Override
    public ValetDto getValetById(Long id) {
        Valet valet = modelMapper.map(valetRepository.findById(id), Valet.class);
        if (valet == null) {
            throw new EntityNotFoundException("Valet not found with ID: " + id);
        }
        ValetDto valetDto = modelMapper.map(valet, ValetDto.class);

        return valetDto;
    }

    /**
     * @param regNumber
     * @return valetDto
     * This method is used to get a valet job by regNumber. We are using the valetRepository to get the valet by regNumber.
     * If the valet is not found we throw an exception.
     * If the valet is found we return the valetDto.
     */
    @Override
    public ValetDto getCarByRegNumber(String regNumber) {
        Optional<Valet> valet = valetRepository.findValetByRegNumberIgnoreCase(regNumber);
        if (!valet.isPresent()) {
            throw new EntityNotFoundException("Valet not found with regNumber: " + regNumber);
        }
        Valet valet1 = valet.get();
        ValetDto valetDto = modelMapper.map(valet1, ValetDto.class);
        return valetDto;
    }



    /**
     * @param valetDto
     * @return ValetDto
     * This method is used to start a valet job. We are using the model mapper to map the valetDto to the Valet entity.
     * When the button start clicked in the front end, this method changes the JobStatus to "STARTS" and saves the valet to the database.
     * We are then saving the valet to the database and returning the valetDto.
     */
    @Override
    public ValetDto startsValet(ValetDto valetDto) {
        Valet valet = modelMapper.map(valetDto, Valet.class);
        valet.setJobStatus(JobStatus.STARTS);
        valetRepository.save(valet);
        return modelMapper.map(valet, ValetDto.class);
    }

    /**
     * @param valetDto
     * @return ValetDto
     * This method is used to finish a valet job. We are using the model mapper to map the valetDto to the Valet entity.
     * When the button finish clicked in the front end, this method changes the JobStatus to "FINISH" and saves the valet
     * to the ValetCompleted database. We are then saving the valet to the database and deleting the valet from the Valet database.
     */
    @Override
    public ValetDto finishingValet(ValetDto valetDto) {
        Valet valet = modelMapper.map(valetDto, Valet.class);
        Optional<Valet> optionalValet = valetRepository.findById(valet.getId());
        System.out.println(optionalValet);
        if (optionalValet.get().getJobStatus() == JobStatus.STARTS) {

            valet.setJobStatus(JobStatus.FINISHED);
            valetRepository.save(valet);

            ValetCompleted valetCompleted = modelMapper.map(valet, ValetCompleted.class);
            ValetCompletedDto valetCompletedDto = modelMapper.map(valetCompleted, ValetCompletedDto.class);

            valetCompletedDto.setDateCreated(LocalDateTime.now());
            if (valetCompleted != null){
                valetCompletedService.addValetCompleted(valetCompletedDto);

                valetRepository.deleteById(valet.getId());

            }

            return modelMapper.map(valet, ValetDto.class);
        } else {
            throw new IllegalArgumentException("Valet not finished! " + valet.getJobStatus());
        }
    }

}
