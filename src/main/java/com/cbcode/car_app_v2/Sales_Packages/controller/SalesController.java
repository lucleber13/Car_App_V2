package com.cbcode.car_app_v2.Sales_Packages.controller;

import com.cbcode.car_app_v2.Sales_Packages.model.DTO.SalesDto;
import com.cbcode.car_app_v2.Sales_Packages.service.impl.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {
    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SalesDto>> getAllSales() {
        return ResponseEntity.ok(salesService.getAllSales());
    }
}
