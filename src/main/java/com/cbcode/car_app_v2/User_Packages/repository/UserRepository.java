package com.cbcode.car_app_v2.User_Packages.repository;

import com.cbcode.car_app_v2.User_Packages.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    Optional<User> findByFirstNameIgnoreCase(String firstName);
}
