package com.cbcode.car_app_v2.Valet_Packages.model;

import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.User_Packages.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity(name = "Valet")
@Table(name = "valet")
@SequenceGenerator(name = "valet_seq", sequenceName = "valet_seq", allocationSize = 1)
public class Valet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valet_seq")
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

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users;

    public Valet() {
    }

    public Valet(String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber, String customerName,
                 JobStatus jobStatus, boolean g3ProtectionRequired, String valetComments, boolean polishMachineRequired, Date dateRequired,
                 CarStatus carStatus) {
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

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public boolean getG3ProtectionRequired() {
        return g3ProtectionRequired;
    }

    public void setG3ProtectionRequired(boolean g3ProtectionRequired) {
        this.g3ProtectionRequired = g3ProtectionRequired;
    }

    public String getValetComments() {
        return valetComments;
    }

    public void setValetComments(String valetComments) {
        this.valetComments = valetComments;
    }

    public boolean getPolishMachineRequired() {
        return polishMachineRequired;
    }

    public void setPolishMachineRequired(boolean polishMachineRequired) {
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
    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Valet valet)) return false;
        return Objects.equals(getId(), valet.getId())
                && Objects.equals(getBrand(), valet.getBrand())
                && Objects.equals(getModel(), valet.getModel())
                && Objects.equals(getColor(), valet.getColor())
                && Objects.equals(getRegNumber(), valet.getRegNumber())
                && Objects.equals(getChassisNumber(), valet.getChassisNumber())
                && Objects.equals(getKeysNumber(), valet.getKeysNumber())
                && Objects.equals(getCustomerName(), valet.getCustomerName())
                && getJobStatus() == valet.getJobStatus()
                && Objects.equals(getG3ProtectionRequired(), valet.getG3ProtectionRequired())
                && Objects.equals(getValetComments(), valet.getValetComments())
                && Objects.equals(getPolishMachineRequired(), valet.getPolishMachineRequired())
                && Objects.equals(getDateRequired(), valet.getDateRequired())
                && getCarStatus() == valet.getCarStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), getJobStatus(), getG3ProtectionRequired(), getValetComments(), getPolishMachineRequired(),
                getDateRequired(), getCarStatus());
    }

    @Override
    public String toString() {
        return "Valet{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", reg_number='" + regNumber + '\'' +
                ", chassis_number='" + chassisNumber + '\'' +
                ", keys_number=" + keysNumber +
                ", customer_name='" + customerName + '\'' +
                ", job_status=" + jobStatus +
                ", g3_protection_required=" + g3ProtectionRequired +
                ", valet_comments='" + valetComments + '\'' +
                ", polish_machine_required=" + polishMachineRequired +
                ", date_required=" + dateRequired +
                ", car_status=" + carStatus +
                '}';
    }
}
