package com.cbcode.car_app_v2.JobForms_Packages.model;

import com.cbcode.car_app_v2.Car_Package.model.Car;
import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.Enums.WorkshopJobsOptions;
import com.cbcode.car_app_v2.Sales_Packages.model.Sales;
import com.cbcode.car_app_v2.User_Packages.model.User;
import com.cbcode.car_app_v2.Valet_Packages.model.Valet;
import com.cbcode.car_app_v2.Workshop_Packages.model.Workshop;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity(name = "JobForms")
@Table(name = "job_forms")
@SequenceGenerator(name = "job_forms_seq", sequenceName = "job_forms_seq", allocationSize = 1)
public class JobForms {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_forms_seq")
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
    @Temporal(TemporalType.DATE)
    private Date dateRequired; // date when the car sold will be handed over to the customer
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus; // status of the car in the process of works to be done.
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus; // job status of the car is SOLD or STOCK.
    @Enumerated(EnumType.STRING)
    private Set<WorkshopJobsOptions> workshopJobsOptions; // options for the workshop job to be done.
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users; // user who create the form for the car sold or stock.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "valet_id")
    private Valet valet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_id")
    private Sales sales;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    public JobForms() {
    }

    public JobForms(String brand, String model, String color, String regNumber, String chassisNumber, Integer keys_number,
                    String customerName, JobStatus jobStatus, Boolean g3ProtectionRequired, String valetComments,
                    Boolean polishMachineRequired, Date dateRequired, CarStatus carStatus,
                    Set<WorkshopJobsOptions> workshopJobsOptions, String workshopComments) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keys_number;
        this.customerName = customerName;
        this.jobStatus = jobStatus;
        this.g3ProtectionRequired = g3ProtectionRequired;
        this.valetComments = valetComments;
        this.polishMachineRequired = polishMachineRequired;
        this.dateRequired = dateRequired;
        this.carStatus = carStatus;
        this.workshopJobsOptions = workshopJobsOptions;
        this.workshopComments = workshopComments;
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

    public Boolean getG3ProtectionRequired() {
        return g3ProtectionRequired;
    }

    public void setG3ProtectionRequired(Boolean g3ProtectionRequired) {
        this.g3ProtectionRequired = g3ProtectionRequired;
    }

    public String getValetComments() {
        return valetComments;
    }

    public void setValetComments(String valetComments) {
        this.valetComments = valetComments;
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

    public String getWorkshopComments() {
        return workshopComments;
    }

    public void setWorkshopComments(String workshopComments) {
        this.workshopComments = workshopComments;
    }

    public Set<WorkshopJobsOptions> getWorkshopJobsOptions() {
        return workshopJobsOptions;
    }

    public void setWorkshopJobsOptions(Set<WorkshopJobsOptions> workshopJobsOptions) {
        this.workshopJobsOptions = workshopJobsOptions;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Valet getValet() {
        return valet;
    }

    public void setValet(Valet valet) {
        this.valet = valet;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobForms that)) return false;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getBrand(), that.getBrand())
                && Objects.equals(getModel(), that.getModel())
                && Objects.equals(getColor(), that.getColor())
                && Objects.equals(getRegNumber(), that.getRegNumber())
                && Objects.equals(getChassisNumber(), that.getChassisNumber())
                && Objects.equals(getKeysNumber(), that.getKeysNumber())
                && Objects.equals(getCustomerName(), that.getCustomerName())
                && getJobStatus() == that.getJobStatus()
                && Objects.equals(getG3ProtectionRequired(), that.getG3ProtectionRequired())
                && Objects.equals(getValetComments(), that.getValetComments())
                && Objects.equals(getWorkshopComments(), that.getWorkshopComments())
                && Objects.equals(getPolishMachineRequired(), that.getPolishMachineRequired())
                && Objects.equals(getDateRequired(), that.getDateRequired())
                && getCarStatus() == that.getCarStatus()
                && getWorkshopJobsOptions() == that.getWorkshopJobsOptions();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getCustomerName(), getJobStatus(), getG3ProtectionRequired(), getValetComments(), getPolishMachineRequired(),
                getDateRequired(), getCarStatus(), getWorkshopComments(), getWorkshopJobsOptions());
    }

    @Override
    public String toString() {
        return "JobForms{" +
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
