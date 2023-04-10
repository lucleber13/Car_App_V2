package com.cbcode.car_app_v2.Car_Package.repository;

import com.cbcode.car_app_v2.Car_Package.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
