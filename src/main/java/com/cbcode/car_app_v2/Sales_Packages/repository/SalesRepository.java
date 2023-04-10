package com.cbcode.car_app_v2.Sales_Packages.repository;

import com.cbcode.car_app_v2.Sales_Packages.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
}
