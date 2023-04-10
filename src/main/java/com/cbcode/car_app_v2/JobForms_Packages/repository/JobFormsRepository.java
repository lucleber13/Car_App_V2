package com.cbcode.car_app_v2.JobForms_Packages.repository;

import com.cbcode.car_app_v2.JobForms_Packages.model.JobForms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobFormsRepository extends JpaRepository<JobForms, Long> {
    Optional<JobForms> findJobCreationByRegNumberIgnoreCase(String regNumber);
    Optional<JobForms> findJobCreationByChassisNumberIgnoreCase(String chassisNumber);
    List<JobForms> findJobCreationByModelContainingIgnoreCase(String model);
    List<JobForms> findJobCreationByCustomerNameContainingIgnoreCase(String customerName);
}
