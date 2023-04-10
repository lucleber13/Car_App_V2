package com.cbcode.car_app_v2.Sales_Packages.model;

import com.cbcode.car_app_v2.Car_Package.model.Car;
import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.User_Packages.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.*;

@Entity(name = "Sales")
@Table(name = "sales")
@SequenceGenerator(name = "sales_seq", sequenceName = "sales_seq", allocationSize = 1)
public class Sales{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_seq")
    private Long id;
    private String brand; // brand of the car
    private String model; // model of the car
    private String color; // color of the car
    private String regNumber; // registration number of the car
    private String chassisNumber; // chassis number of the car
    private Integer keysNumber; // number of keys of the car
    private String customerName; // name of the customer who bought the car
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateHandover; // date when the car is handed over to the customer
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus; // job status of the car is SOLD or STOCK.
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateRequired; // date when the car sold will be handed over to the customer
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus; // status of the car in the process of works to be done.

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User users;

    public Sales() {
    }

    public Sales(String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber,
                 String customerName, JobStatus jobStatus, Date dateRequired, CarStatus car_status, Date dateHandover) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
        this.customerName = customerName;
        this.jobStatus = jobStatus;
        this.dateRequired = dateRequired;
        this.carStatus = car_status;
        this.dateHandover = dateHandover;
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

    public Date getDateHandover() {
        return dateHandover;
    }

    public void setDateHandover(Date dateHandover) {
        this.dateHandover = dateHandover;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
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
        if (!(o instanceof Sales sales)) return false;
        return Objects.equals(getId(), sales.getId())
                && Objects.equals(getBrand(), sales.getBrand())
                && Objects.equals(getModel(), sales.getModel())
                && Objects.equals(getColor(), sales.getColor())
                && Objects.equals(getRegNumber(), sales.getRegNumber())
                && Objects.equals(getChassisNumber(), sales.getChassisNumber())
                && Objects.equals(getKeysNumber(), sales.getKeysNumber())
                && Objects.equals(getCustomerName(), sales.getCustomerName())
                && Objects.equals(getDateHandover(), sales.getDateHandover())
                && getJobStatus() == sales.getJobStatus()
                && Objects.equals(getDateRequired(), sales.getDateRequired())
                && getCarStatus() == sales.getCarStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), getDateHandover(), getJobStatus(), getDateRequired(), getCarStatus());
    }

    @Override
    public String toString() {
        return "Sales{" +
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
