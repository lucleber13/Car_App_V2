package com.cbcode.car_app_v2.Workshop_Packages.model;

import com.cbcode.car_app_v2.Car_Package.model.Car;
import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.Enums.WorkshopJobsOptions;
import com.cbcode.car_app_v2.User_Packages.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.*;

@Entity(name = "Workshop")
@Table(name = "workshop")
@SequenceGenerator(name = "workshop_seq", sequenceName = "workshop_seq", allocationSize = 1)
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workshop_seq")
    private Long id;
    private String brand; // brand of the car
    private String model; // model of the car
    private String color; // color of the car
    private String regNumber; // registration number of the car
    private String chassisNumber; // chassis number of the car
    private Integer keysNumber; // number of keys of the car
    private String customerName; // name of the customer who bought the car
    private String workshopComments; // comments for the workshop job to be done.
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus; // job status of the car is SOLD or STOCK.
    @Enumerated(EnumType.STRING)
    private Set<WorkshopJobsOptions> workshopJobsOptions; // options for the workshop job to be done.
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus; // status of the car in the process of works to be done.
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateRequired; // date when the car sold will be handed over to the customer
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User users;

    public Workshop() {
    }

    public Workshop(String brand, String model, String color, String regNumber, String chassisNumber, Integer keysNumber, String customerName,
                    JobStatus jobStatus, String workshopComments, Set<WorkshopJobsOptions> workshopJobsOptions, Date dateRequired,
                    CarStatus carStatus) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
        this.customerName = customerName;
        this.jobStatus = jobStatus;
        this.workshopComments = workshopComments;
        this.workshopJobsOptions = workshopJobsOptions;
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

    public String getWorkshopComments() {
        return workshopComments;
    }

    public void setWorkshopComments(String workshopComments) {
        this.workshopComments = workshopComments;
    }

    public Set<WorkshopJobsOptions> getWorshopJobsOptions() {
        return workshopJobsOptions;
    }

    public void setWorshopJobsOptions(Set<WorkshopJobsOptions> workshopJobsOptions) {
        this.workshopJobsOptions = workshopJobsOptions;
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
        if (!(o instanceof Workshop workshop)) return false;
        return Objects.equals(getId(), workshop.getId())
                && Objects.equals(getBrand(), workshop.getBrand())
                && Objects.equals(getModel(), workshop.getModel())
                && Objects.equals(getColor(), workshop.getColor())
                && Objects.equals(getRegNumber(), workshop.getRegNumber())
                && Objects.equals(getChassisNumber(), workshop.getChassisNumber())
                && Objects.equals(getKeysNumber(), workshop.getKeysNumber())
                && Objects.equals(getCustomerName(), workshop.getCustomerName())
                && getJobStatus() == workshop.getJobStatus()
                && Objects.equals(getWorkshopComments(), workshop.getWorkshopComments())
                && getWorshopJobsOptions() == workshop.getWorshopJobsOptions()
                && Objects.equals(getDateRequired(), workshop.getDateRequired())
                && getCarStatus() == workshop.getCarStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), getJobStatus(), getWorkshopComments(), getWorshopJobsOptions(), getDateRequired(),
                getCarStatus());
    }

    @Override
    public String toString() {
        return "Workshop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", reg_number='" + regNumber + '\'' +
                ", chassis_number='" + chassisNumber + '\'' +
                ", keys_number=" + keysNumber +
                ", customer_name='" + customerName + '\'' +
                ", job_status=" + jobStatus +
                ", workshop_comments='" + workshopComments + '\'' +
                ", workshop_jobs_options=" + workshopJobsOptions +
                ", date_required=" + dateRequired +
                ", car_status=" + carStatus +
                '}';
    }

}
