package com.cbcode.car_app_v2.Valet_Packages.controller;

import com.cbcode.car_app_v2.Exceptions.CarNotFoundException;
import com.cbcode.car_app_v2.Exceptions.ValetNotFoundException;
import com.cbcode.car_app_v2.Valet_Packages.model.DTO.ValetDto;
import com.cbcode.car_app_v2.Valet_Packages.service.impl.ValetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/valet")
public class ValetController {
    private final ValetService valetService;
    // Constructor injection
    public ValetController(ValetService valetService) {
        this.valetService = valetService;
    }

    // This method is called from the JobForms class. Then the valetDto is added to the JobFormsDto.
    @PostMapping("/add-valet")
    public ResponseEntity<ValetDto> addValet(@RequestBody ValetDto savedValetDto){
            return ResponseEntity.ok().body(valetService.addValet(savedValetDto));
    }

    // This method is used to update a valet job. We are using the model mapper to map the valetDto to the Valet entity.
    // We are then saving the valet to the database and returning the valetDto.
    @PutMapping("/update-valet")
    public ResponseEntity<ValetDto> updateValet(@RequestBody ValetDto valetDto){
        try {
            return ResponseEntity.ok().body(valetService.updateValet(valetDto));
        } catch (Exception e) {
            throw new ValetNotFoundException("Valet job with ID " + valetDto.getId() + " not found");
        }
    }

    // This method is used to delete a valet job. We are using the model mapper to map the valetDto to the Valet entity.
    @DeleteMapping("/delete-valet/{id}")
    public ResponseEntity<String> deleteValet(@PathVariable Long id) {
        try {
            valetService.deleteValet(id);
            return ResponseEntity.ok("Valet job with ID " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Valet job with ID " + id + " not found");
        }
    }

    // This method is used to get all valet jobs.
    @GetMapping("/all-valets")
    public ResponseEntity<List<ValetDto>> getAllValets(){
        return ResponseEntity.ok().body(valetService.getAllValets());
    }

    // This method is used to get a valet job by id.
    @GetMapping("/{id}")
    public ResponseEntity<ValetDto> getValetById(@PathVariable(name="id") Long id){
        try {
            return ResponseEntity.ok(valetService.getValetById(id));
        } catch (Exception e) {
            throw new ValetNotFoundException("Valet not found with ID: " + id);
        }
    }

    // This method is used to get a valet job by reg number.
    @GetMapping("/regNumber/{regNumber}")
    public ResponseEntity<ValetDto> getValetByRegNumber(@PathVariable String regNumber){
        try {
            return ResponseEntity.ok(valetService.getCarByRegNumber(regNumber));
        } catch (Exception e) {
            throw new CarNotFoundException("Car not found with reg number: " + regNumber);
        }
    }

    // This method is used to start a valet job. We are using the model mapper to map the valetDto to the Valet entity.
    // We are then saving the valet to the database and returning the valetDto.
    @PutMapping("/start-valet")
    public ResponseEntity<ValetDto> startValet(@RequestBody ValetDto valetDto){
        try {
            return ResponseEntity.ok(valetService.startsValet(valetDto));
        } catch (Exception e) {
            throw new ValetNotFoundException("Valet not found with ID: " + valetDto.getId());
        }
    }

    // This method is used to finish a valet job. We are using the model mapper to map the valetDto to the Valet entity.
    // We are then saving the valet to the database and returning the valetDto.
    @PutMapping("/finish-valet")
    public ResponseEntity<ValetDto> finishValet(@RequestBody ValetDto valetDto){
        try {
            return ResponseEntity.ok(valetService.finishingValet(valetDto));
        } catch (Exception e) {
            throw new ValetNotFoundException("Valet not found with ID: " + valetDto.getId());
        }
    }


}
