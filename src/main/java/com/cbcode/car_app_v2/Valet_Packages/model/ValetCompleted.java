package com.cbcode.car_app_v2.Valet_Packages.model;

import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "valet_completed")
@SequenceGenerator(name = "valet_completed_seq", sequenceName = "valet_completed_seq", allocationSize = 1)
public class ValetCompleted {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valet_completed_seq")
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
    private JobStatus jobStatus; // job status of the car is STARTS or FINISHED.
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus; // status of the car in the process of works to be done.

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateCreated; // date when the car sold will be handed over to the customer

    public ValetCompleted() {
    }

    public ValetCompleted(String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber,
                          String customerName, boolean g3ProtectionRequired, boolean polishMachineRequired, String valetComments,
                          Date dateRequired, JobStatus jobStatus, CarStatus carStatus, LocalDateTime dateCreated) {
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
        this.dateCreated = dateCreated;
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

    public boolean isG3ProtectionRequired() {
        return g3ProtectionRequired;
    }

    public void setG3ProtectionRequired(boolean g3ProtectionRequired) {
        this.g3ProtectionRequired = g3ProtectionRequired;
    }

    public boolean isPolishMachineRequired() {
        return polishMachineRequired;
    }

    public void setPolishMachineRequired(boolean polishMachineRequired) {
        this.polishMachineRequired = polishMachineRequired;
    }

    public String getValetComments() {
        return valetComments;
    }

    public void setValetComments(String valetComments) {
        this.valetComments = valetComments;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValetCompleted that)) return false;
        return isG3ProtectionRequired() == that.isG3ProtectionRequired()
                && isPolishMachineRequired() == that.isPolishMachineRequired()
                && Objects.equals(getId(), that.getId())
                && Objects.equals(getBrand(), that.getBrand())
                && Objects.equals(getModel(), that.getModel())
                && Objects.equals(getColor(), that.getColor())
                && Objects.equals(getRegNumber(), that.getRegNumber())
                && Objects.equals(getChassisNumber(), that.getChassisNumber())
                && Objects.equals(getKeysNumber(), that.getKeysNumber())
                && Objects.equals(getCustomerName(), that.getCustomerName())
                && Objects.equals(getValetComments(), that.getValetComments())
                && Objects.equals(getDateRequired(), that.getDateRequired())
                && getJobStatus() == that.getJobStatus()
                && getCarStatus() == that.getCarStatus()
                && Objects.equals(getDateCreated(), that.getDateCreated());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), isG3ProtectionRequired(), isPolishMachineRequired(), getValetComments(), getDateRequired(),
                getJobStatus(), getCarStatus(), getDateCreated());
    }

    @Override
    public String toString() {
        return "ValetCompleted{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", keysNumber=" + keysNumber +
                ", customerName='" + customerName + '\'' +
                ", g3ProtectionRequired=" + g3ProtectionRequired +
                ", polishMachineRequired=" + polishMachineRequired +
                ", valetComments='" + valetComments + '\'' +
                ", dateRequired=" + dateRequired +
                ", jobStatus=" + jobStatus +
                ", carStatus=" + carStatus +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
