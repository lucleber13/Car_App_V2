package com.cbcode.car_app_v2.Sales_Packages.service;

import com.cbcode.car_app_v2.Sales_Packages.model.DTO.SalesDto;

import java.util.List;

public interface ISalesService {
    List<SalesDto> getAllSales();
    SalesDto getSalesById(Long id);
    SalesDto addSales(SalesDto salesDto);
    SalesDto updateSales(SalesDto salesDto);
    void deleteSales(Long id);
    SalesDto getSalesByCustomerName(String customerName);
    SalesDto getSalesByBrand(String brand);
    SalesDto getSalesByModel(String model);
    SalesDto getSalesByRegNumber(String regNumber);
    SalesDto getSalesByChassisNumber(String chassisNumber);
    SalesDto getSalesByUserid(Long userId);

}
