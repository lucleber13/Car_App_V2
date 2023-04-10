package com.cbcode.car_app_v2.Workshop_Packages.repository;

import com.cbcode.car_app_v2.Workshop_Packages.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
