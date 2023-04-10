package com.cbcode.car_app_v2.Valet_Packages.repository;

import com.cbcode.car_app_v2.Valet_Packages.model.Valet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValetRepository extends JpaRepository<Valet, Long> {

    Optional<Valet> findValetByRegNumberIgnoreCase(String regNumber);
    Optional<Valet> findValetById(Long id);
}
