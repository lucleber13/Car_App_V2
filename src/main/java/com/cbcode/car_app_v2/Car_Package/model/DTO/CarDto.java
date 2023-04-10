package com.cbcode.car_app_v2.Car_Package.model.DTO;

import java.util.Objects;

public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private String regNumber;
    private String chassisNumber;
    private Integer keysNumber;

    public CarDto() {
    }

    public CarDto(Long id, String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
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

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public Integer getKeysNumber() {
        return keysNumber;
    }

    public void setKeysNumber(Integer keysNumber) {
        this.keysNumber = keysNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarDto carDto)) return false;
        return Objects.equals(getId(), carDto.getId())
                && Objects.equals(getBrand(), carDto.getBrand())
                && Objects.equals(getModel(), carDto.getModel())
                && Objects.equals(getColor(), carDto.getColor())
                && Objects.equals(getRegNumber(), carDto.getRegNumber())
                && Objects.equals(getChassisNumber(), carDto.getChassisNumber())
                && Objects.equals(getKeysNumber(), carDto.getKeysNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(),
                getKeysNumber());
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", keysNumber=" + keysNumber +
                '}';
    }
}
