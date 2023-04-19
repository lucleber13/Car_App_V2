package com.cbcode.car_app_v2.Workshop_Packages.model.DTO;

import com.cbcode.car_app_v2.Car_Package.model.DTO.CarDto;
import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.Enums.WorkshopJobsOptions;
import com.cbcode.car_app_v2.User_Packages.model.DTO.UserDto;
import com.cbcode.car_app_v2.User_Packages.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class WorkshopDto implements Serializable {
    private Long id;
    private String brand; // brand of the car
    private String model; // model of the car
    private String color; // color of the car
    private String regNumber; // registration number of the car
    private String chassisNumber; // chassis number of the car
    private Integer keysNumber; // number of keys of the car
    private String customerName; // name of the customer who bought the car
    private String workshopComments; // comments for the workshop job to be done.
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus; // job status of the car is SOLD or STOCK.
    @Enumerated(EnumType.STRING)
    private Set<WorkshopJobsOptions> workshopJobsOptions; // options for the workshop job to be done.
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus; // status of the car in the process of works to be done.
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateRequired; // date when the car sold will be handed over to the customer.
    private UserDto users; // user object to be used in the workshop job process to be done.

    public WorkshopDto() {
    }

    public WorkshopDto(Long id, String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber,
                       String customerName, String workshopComments, JobStatus jobStatus, Set<WorkshopJobsOptions> workshopJobsOptions,
                       CarStatus carStatus, Date dateRequired) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
        this.customerName = customerName;
        this.workshopComments = workshopComments;
        this.jobStatus = jobStatus;
        this.workshopJobsOptions = workshopJobsOptions;
        this.carStatus = carStatus;
        this.dateRequired = dateRequired;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getWorkshopComments() {
        return workshopComments;
    }

    public void setWorkshopComments(String workshopComments) {
        this.workshopComments = workshopComments;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Set<WorkshopJobsOptions> getWorkshopJobsOptions() {
        return workshopJobsOptions;
    }

    public void setWorkshopJobsOptions(Set<WorkshopJobsOptions> workshopJobsOptions) {
        this.workshopJobsOptions = workshopJobsOptions;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
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
        if (!(o instanceof WorkshopDto that)) return false;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getBrand(), that.getBrand())
                && Objects.equals(getModel(), that.getModel())
                && Objects.equals(getColor(), that.getColor())
                && Objects.equals(getRegNumber(), that.getRegNumber())
                && Objects.equals(getChassisNumber(), that.getChassisNumber())
                && Objects.equals(getKeysNumber(), that.getKeysNumber())
                && Objects.equals(getCustomerName(), that.getCustomerName())
                && Objects.equals(getWorkshopComments(), that.getWorkshopComments())
                && getJobStatus() == that.getJobStatus()
                && getWorkshopJobsOptions() == that.getWorkshopJobsOptions()
                && getCarStatus() == that.getCarStatus()
                && Objects.equals(getDateRequired(), that.getDateRequired());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), getWorkshopComments(), getJobStatus(), getWorkshopJobsOptions(), getCarStatus(),
                getDateRequired());
    }

    @Override
    public String toString() {
        return "WorkshopDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", reg_number='" + regNumber + '\'' +
                ", chassis_number='" + chassisNumber + '\'' +
                ", keys_number=" + keysNumber +
                ", customer_name='" + customerName + '\'' +
                ", workshop_comments='" + workshopComments + '\'' +
                ", job_status=" + jobStatus +
                ", workshop_jobs_options=" + workshopJobsOptions +
                ", car_status=" + carStatus +
                ", date_required=" + dateRequired +
                '}';
    }
}
