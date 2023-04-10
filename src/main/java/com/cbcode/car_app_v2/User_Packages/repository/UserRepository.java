package com.cbcode.car_app_v2.User_Packages.repository;

import com.cbcode.car_app_v2.User_Packages.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
