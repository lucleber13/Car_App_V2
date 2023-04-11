package com.cbcode.car_app_v2.Sales_Packages.model.DTO;

import com.cbcode.car_app_v2.Car_Package.model.DTO.CarDto;
import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.User_Packages.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SalesDto {
    private Long id;
    private String brand; // brand of the car
    private String model; // model of the car
    private String color; // color of the car
    private String regNumber; // registration number of the car
    private String chassisNumber; // chassis number of the car
    private Integer keysNumber; // number of keys of the car
    private String customerName; // name of the customer who bought the car
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateHandover; // date when the car is handed over to the customer
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus; // job status of the car is SOLD or STOCK.
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateRequired; // date when the car sold will be handed over to the customer
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus; // status of the car in the process of works to be done.
    private User users; // user who is selling the car.

    public SalesDto() {
    }

    public SalesDto(Long id, String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber,
                    String customerName, Date dateHandover, JobStatus jobStatus, Date dateRequired, CarStatus carStatus) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
        this.customerName = customerName;
        this.dateHandover = dateHandover;
        this.jobStatus = jobStatus;
        this.dateRequired = dateRequired;
        this.carStatus = carStatus;
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

    public void setReg_number(String reg_number) {
        this.regNumber = reg_number;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassis_number(String chassis_number) {
        this.chassisNumber = chassis_number;
    }

    public Integer getKeysNumber() {
        return keysNumber;
    }

    public void setKeys_number(Integer keys_number) {
        this.keysNumber = keys_number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomer_name(String customer_name) {
        this.customerName = customer_name;
    }

    public Date getDateHandover() {
        return dateHandover;
    }

    public void setDate_handover(Date date_handover) {
        this.dateHandover = date_handover;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJob_status(JobStatus job_status) {
        this.jobStatus = job_status;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDate_required(Date date_required) {
        this.dateRequired = date_required;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCar_status(CarStatus car_status) {
        this.carStatus = car_status;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesDto salesDto)) return false;
        return Objects.equals(getId(), salesDto.getId())
                && Objects.equals(getBrand(), salesDto.getBrand())
                && Objects.equals(getModel(), salesDto.getModel())
                && Objects.equals(getColor(), salesDto.getColor())
                && Objects.equals(getRegNumber(), salesDto.getRegNumber())
                && Objects.equals(getChassisNumber(), salesDto.getChassisNumber())
                && Objects.equals(getKeysNumber(), salesDto.getKeysNumber())
                && Objects.equals(getCustomerName(), salesDto.getCustomerName())
                && Objects.equals(getDateHandover(), salesDto.getDateHandover())
                && getJobStatus() == salesDto.getJobStatus()
                && Objects.equals(getDateRequired(), salesDto.getDateRequired())
                && getCarStatus() == salesDto.getCarStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), getDateHandover(), getJobStatus(), getDateRequired(), getCarStatus());
    }

    @Override
    public String toString() {
        return "SalesDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", reg_number='" + regNumber + '\'' +
                ", chassis_number='" + chassisNumber + '\'' +
                ", keys_number=" + keysNumber +
                ", customer_name='" + customerName + '\'' +
                ", date_handover=" + dateHandover +
                ", job_status=" + jobStatus +
                ", date_required=" + dateRequired +
                ", car_status=" + carStatus +
                '}';
    }
}
