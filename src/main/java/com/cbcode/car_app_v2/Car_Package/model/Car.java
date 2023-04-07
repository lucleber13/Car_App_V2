package com.cbcode.car_app_v2.Car_Package.model;

import jakarta.persistence.*;

@Entity(name = "Car")
@Table(name = "car")
@SequenceGenerator(name = "car_seq", sequenceName = "car_seq", allocationSize = 1)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    private Long id;
    private String brand;
    private String model;
    private String color;
    private String reg_number;
    private String chassis_number;
    private Integer keys_number;

    public Car() {
    }

    public Car(String brand, String model, String color, String reg_number, String chassis_number, Integer keys_number) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.reg_number = reg_number;
        this.chassis_number = chassis_number;
        this.keys_number = keys_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public String getChassis_number() {
        return chassis_number;
    }

    public void setChassis_number(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    public Integer getKeys_number() {
        return keys_number;
    }

    public void setKeys_number(Integer keys_number) {
        this.keys_number = keys_number;
    }

}
