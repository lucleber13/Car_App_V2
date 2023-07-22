package com.cbcode.car_app_v2.JobForms_Packages.model.DTO;

import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.Enums.WorkshopJobsOptions;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class JobFormsDto {
    private Long id;
    private String brand; // brand of the car
    private String model; // model of the car
    private String color; // color of the car
    private String regNumber; // registration number of the car
    private String chassisNumber; // chassis number of the car
    private Integer keysNumber; // number of keys of the car
    private String customerName; // name of the customer who bought the car
    private String valetComments; // comments for the valet job to be done.
    private String workshopComments; // comments for the workshop job to be done.
    private Boolean g3ProtectionRequired; // g3 protection application on car
    private Boolean polishMachineRequired; // polish machine required for the job.
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateRequired; // date when the car sold will be handed over to the customer
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus; // status of the car in the process of works to be done.
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus; // job status of the car is SOLD or STOCK.
    @Enumerated(EnumType.STRING)
    private Set<WorkshopJobsOptions> workshopJobsOptions; // options for the workshop job to be done.
    private Boolean isNeededValet; // checks if it needs creates a valet job for the car.
    private Boolean isNeededWorkshop; // checks if it needs creates a workshop job for the car.
    private Boolean isNeededSales = true; // checks if it needs creates a sales job for the car.


    public JobFormsDto() {
    }

    public JobFormsDto(Long id, String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber,
                       String customerName, JobStatus jobStatus, Boolean g3ProtectionRequired, String valetComments, Boolean polishMachineRequired,
                       Date dateRequired, CarStatus carStatus, Set<WorkshopJobsOptions> workshopJobsOptions, String workshopComments, Boolean isNeededValet,
                       Boolean isNeededWorkshop, Boolean isNeededSales) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
        this.customerName = customerName;
        this.jobStatus = jobStatus;
        this.g3ProtectionRequired = g3ProtectionRequired;
        this.valetComments = valetComments;
        this.polishMachineRequired = polishMachineRequired;
        this.dateRequired = dateRequired;
        this.carStatus = carStatus;
        this.workshopJobsOptions = workshopJobsOptions;
        this.workshopComments = workshopComments;
        this.isNeededValet = isNeededValet;
        this.isNeededWorkshop = isNeededWorkshop;
        this.isNeededSales = isNeededSales;
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

    public String getValetComments() {
        return valetComments;
    }

    public void setValetComments(String valetComments) {
        this.valetComments = valetComments;
    }

    public String getWorkshopComments() {
        return workshopComments;
    }

    public void setWorkshopComments(String workshopComments) {
        this.workshopComments = workshopComments;
    }

    public Boolean getG3ProtectionRequired() {
        return g3ProtectionRequired;
    }

    public void setG3ProtectionRequired(Boolean g3ProtectionRequired) {
        this.g3ProtectionRequired = g3ProtectionRequired;
    }

    public Boolean getPolishMachineRequired() {
        return polishMachineRequired;
    }

    public void setPolishMachineRequired(Boolean polishMachineRequired) {
        this.polishMachineRequired = polishMachineRequired;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
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


    public Boolean getNeededValet() {
        return isNeededValet;
    }

    public void setNeededValet(Boolean neededValet) {
        isNeededValet = neededValet;
    }

    public Boolean getNeededWorkshop() {
        return isNeededWorkshop;
    }

    public void setNeededWorkshop(Boolean neededWorkshop) {
        isNeededWorkshop = neededWorkshop;
    }

    public Boolean getNeededSales() {
        return isNeededSales;
    }

    public void setNeededSales(Boolean neededSales) {
        isNeededSales = neededSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobFormsDto that)) return false;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getBrand(), that.getBrand())
                && Objects.equals(getModel(), that.getModel())
                && Objects.equals(getColor(), that.getColor())
                && Objects.equals(getRegNumber(), that.getRegNumber())
                && Objects.equals(getChassisNumber(), that.getChassisNumber())
                && Objects.equals(getKeysNumber(), that.getKeysNumber())
                && Objects.equals(getCustomerName(), that.getCustomerName())
                && Objects.equals(getValetComments(), that.getValetComments())
                && Objects.equals(getWorkshopComments(), that.getWorkshopComments())
                && Objects.equals(getG3ProtectionRequired(), that.getG3ProtectionRequired())
                && Objects.equals(getPolishMachineRequired(), that.getPolishMachineRequired())
                && Objects.equals(getDateRequired(), that.getDateRequired())
                && getCarStatus() == that.getCarStatus()
                && getJobStatus() == that.getJobStatus()
                && getWorkshopJobsOptions() == that.getWorkshopJobsOptions()
                && Objects.equals(getNeededSales(), that.getNeededSales())
                && Objects.equals(getNeededValet(), that.getNeededValet())
                && Objects.equals(getNeededWorkshop(), that.getNeededWorkshop());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), getValetComments(), getWorkshopComments(), getG3ProtectionRequired(), getPolishMachineRequired(),
                getDateRequired(), getCarStatus(), getJobStatus(), getWorkshopJobsOptions(), getNeededSales(), getNeededValet(), getNeededWorkshop());
    }

    @Override
    public String toString() {
        return "JobFormsDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", keysNumber=" + keysNumber +
                ", customerName='" + customerName + '\'' +
                ", valetComments='" + valetComments + '\'' +
                ", workshopComments='" + workshopComments + '\'' +
                ", g3ProtectionRequired=" + g3ProtectionRequired +
                ", polishMachineRequired=" + polishMachineRequired +
                ", dateRequired=" + dateRequired +
                ", carStatus=" + carStatus +
                ", jobStatus=" + jobStatus +
                ", workshopJobsOptions=" + workshopJobsOptions +
                '}';
    }
}
