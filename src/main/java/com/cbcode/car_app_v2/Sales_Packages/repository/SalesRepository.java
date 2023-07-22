package com.cbcode.car_app_v2.Sales_Packages.repository;

import com.cbcode.car_app_v2.Sales_Packages.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    Optional<Sales> findSalesByRegNumberIgnoreCase(String regNumber);
    Optional<Sales> findSalesById(Long id);
}
