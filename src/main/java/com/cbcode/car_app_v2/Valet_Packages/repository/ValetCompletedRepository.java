package com.cbcode.car_app_v2.Valet_Packages.repository;

import com.cbcode.car_app_v2.Valet_Packages.model.ValetCompleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValetCompletedRepository extends JpaRepository<ValetCompleted, Long> {

}