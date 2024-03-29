package com.cbcode.car_app_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CarAppV2Application {

    public static void main(String[] args) {
        SpringApplication.run(CarAppV2Application.class, args);
    }

}
