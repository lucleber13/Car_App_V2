package com.cbcode.car_app_v2.Valet_Packages.repository;

import com.cbcode.car_app_v2.Valet_Packages.model.Valet;
import com.cbcode.car_app_v2.Valet_Packages.model.ValetCompleted;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ValetCompletedRepository extends JpaRepository<ValetCompleted, Long> {
    Optional<ValetCompleted> findValetCompletedByRegNumberIgnoreCase(String regNumber);

    @Transactional
    @Modifying
    @Query("DELETE FROM ValetCompleted v WHERE v.dateCreated < :date")
    void deleteValetCompletedByDateCreatedBefore(LocalDateTime date);
}