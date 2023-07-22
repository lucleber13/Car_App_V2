package com.cbcode.car_app_v2.Sales_Packages.service.impl;

import com.cbcode.car_app_v2.Sales_Packages.model.DTO.SalesDto;
import com.cbcode.car_app_v2.Sales_Packages.model.Sales;
import com.cbcode.car_app_v2.Sales_Packages.repository.SalesRepository;
import com.cbcode.car_app_v2.Sales_Packages.service.ISalesService;
import com.cbcode.car_app_v2.User_Packages.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.Streams.stream;

@Service
public class SalesService implements ISalesService {
    private final SalesRepository salesRepository;
    private final ModelMapper modelMapper;

    public SalesService(SalesRepository salesRepository, ModelMapper modelMapper) {
        this.salesRepository = salesRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @return salesDtoList
     * @throws EntityNotFoundException
     * This method is used to get all the sales from the database.
     */
    @Override
    public List<SalesDto> getAllSales() {
        try {
            Sales sales = modelMapper.map(salesRepository.findAll(), Sales.class);
            if (sales == null) {
                throw new EntityNotFoundException("Sales not found");
            } else {
                List<Sales> salesList= salesRepository.findAll();
                List<Sales> salesGetList = salesList
                        .stream()
                        .map(sales1 -> modelMapper.map(sales1, Sales.class))
                        .collect(Collectors.toList());
                List<SalesDto> salesDtoList = modelMapper.map(salesGetList, List.class);
                return salesDtoList;
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("Sales not found" + e.getMessage());
        }

    }

    /**
     * @param id
     * @return
     */
    @Override
    public SalesDto getSalesById(Long id) {
        return null;
    }

    /**
     * @param salesDto
     * @return
     */
    @Override
    public SalesDto addSales(SalesDto salesDto) {
        try {
            Sales sales = modelMapper.map(salesDto, Sales.class);
            Optional<Sales> optionalSales = salesRepository.findSalesByRegNumberIgnoreCase(sales.getRegNumber());
            if (optionalSales.isPresent()) {
                throw new IllegalStateException("Car with registration number " + salesDto.getRegNumber() + " already exists.");
            } else {
                User user = new User();
                user.setId(user.getId());
                Sales savedSales = salesRepository.save(sales);
                return modelMapper.map(savedSales, SalesDto.class);
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("Sales not found" + e.getMessage());
        }
    }

    /**
     * @param salesDto
     * @return
     */
    @Override
    public SalesDto updateSales(SalesDto salesDto) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteSales(Long id) {

    }

    /**
     * @param customerName
     * @return
     */
    @Override
    public SalesDto getSalesByCustomerName(String customerName) {
        return null;
    }

    /**
     * @param brand
     * @return
     */
    @Override
    public SalesDto getSalesByBrand(String brand) {
        return null;
    }

    /**
     * @param model
     * @return
     */
    @Override
    public SalesDto getSalesByModel(String model) {
        return null;
    }

    /**
     * @param regNumber
     * @return
     */
    @Override
    public SalesDto getSalesByRegNumber(String regNumber) {
        return null;
    }

    /**
     * @param chassisNumber
     * @return
     */
    @Override
    public SalesDto getSalesByChassisNumber(String chassisNumber) {
        return null;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public SalesDto getSalesByUserid(Long userId) {
        Sales sales = salesRepository.findSalesById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Sales not found for user with ID: " + userId));

        SalesDto salesDto = modelMapper.map(sales, SalesDto.class);
        return salesDto;
    }
}
