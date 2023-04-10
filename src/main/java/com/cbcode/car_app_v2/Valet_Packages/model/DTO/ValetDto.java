package com.cbcode.car_app_v2.Valet_Packages.model.DTO;

import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.User_Packages.model.DTO.UserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

public class ValetDto {
    private Long id;
    private String brand; // brand of the car
    private String model; // model of the car
    private String color; // color of the car
    private String regNumber; // registration number of the car
    private String chassisNumber; // chassis number of the car
    private Integer keysNumber; // number of keys of the car
    private String customerName; // name of the customer who bought the car
    private boolean g3ProtectionRequired; // g3 protection application on car
    private boolean polishMachineRequired; // polish machine required for the job.
    private String valetComments; // comments for the valet job to be done.

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateRequired; // date when the car sold will be handed over to the customer
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus = null; // job status of the car is SOLD or STOCK.
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus; // status of the car in the process of works to be done.
    private UserDto users; // user who is assigned to the job.

    public ValetDto() {
    }

    public ValetDto(Long id, String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber,
                    String customerName, boolean g3ProtectionRequired, boolean polishMachineRequired, String valetComments,
                    Date dateRequired, JobStatus jobStatus, CarStatus carStatus) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
        this.customerName = customerName;
        this.g3ProtectionRequired = g3ProtectionRequired;
        this.polishMachineRequired = polishMachineRequired;
        this.valetComments = valetComments;
        this.dateRequired = dateRequired;
        this.jobStatus = jobStatus;
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

    public boolean getG3ProtectionRequired() {
        return g3ProtectionRequired;
    }

    public void setG3_protectionRequired(boolean g3_protectionRequired) {
        this.g3ProtectionRequired = g3_protectionRequired;
    }

    public boolean getPolishMachineRequired() {
        return polishMachineRequired;
    }

    public void setPolish_machineRequired(boolean polish_machineRequired) {
        this.polishMachineRequired = polish_machineRequired;
    }

    public String getValetComments() {
        return valetComments;
    }

    public void setValet_comments(String valet_comments) {
        this.valetComments = valet_comments;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDate_required(Date date_required) {
        this.dateRequired = date_required;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJob_status(JobStatus job_status) {
        this.jobStatus = job_status;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCar_status(CarStatus car_status) {
        this.carStatus = car_status;
    }

    public UserDto getUsers() {
        return users;
    }

    public void setUsers(UserDto users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValetDto valetDto)) return false;
        return Objects.equals(getId(), valetDto.getId())
                && Objects.equals(getBrand(), valetDto.getBrand())
                && Objects.equals(getModel(), valetDto.getModel())
                && Objects.equals(getColor(), valetDto.getColor())
                && Objects.equals(getRegNumber(), valetDto.getRegNumber())
                && Objects.equals(getChassisNumber(), valetDto.getChassisNumber())
                && Objects.equals(getKeysNumber(), valetDto.getKeysNumber())
                && Objects.equals(getCustomerName(), valetDto.getCustomerName())
                && Objects.equals(getG3ProtectionRequired(), valetDto.getG3ProtectionRequired())
                && Objects.equals(getPolishMachineRequired(), valetDto.getPolishMachineRequired())
                && Objects.equals(getValetComments(), valetDto.getValetComments())
                && Objects.equals(getDateRequired(), valetDto.getDateRequired())
                && getJobStatus() == valetDto.getJobStatus()
                && getCarStatus() == valetDto.getCarStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), getG3ProtectionRequired(), getPolishMachineRequired(), getValetComments(), getDateRequired(),
                getJobStatus(), getCarStatus());
    }

    @Override
    public String toString() {
        return "ValetDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", reg_number='" + regNumber + '\'' +
                ", chassis_number='" + chassisNumber + '\'' +
                ", keys_number=" + keysNumber +
                ", customer_name='" + customerName + '\'' +
                ", g3_protection_required=" + g3ProtectionRequired +
                ", polish_machine_required=" + polishMachineRequired +
                ", valet_comments='" + valetComments + '\'' +
                ", date_required=" + dateRequired +
                ", job_status=" + jobStatus +
                ", car_status=" + carStatus +
                '}';
    }
}
