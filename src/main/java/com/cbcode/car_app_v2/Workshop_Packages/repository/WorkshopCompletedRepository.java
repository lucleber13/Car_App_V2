package com.cbcode.car_app_v2.Workshop_Packages.repository;

import com.cbcode.car_app_v2.Workshop_Packages.model.WorkshopCompleted;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface WorkshopCompletedRepository extends JpaRepository<WorkshopCompleted, Long> {
    Optional<WorkshopCompleted> findWorkshopCompletedByRegNumberIgnoreCase(String regNumber);

    @Transactional
    @Modifying
    @Query("DELETE FROM WorkshopCompleted v WHERE v.dateCreated < :date")
    void deleteWorkshopCompletedByDateCreatedBefore(LocalDateTime date);
}
