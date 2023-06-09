package com.cbcode.car_app_v2.Car_Package.model;

import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.Enums.WorkshopJobsOptions;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sold_car")
@PrimaryKeyJoinColumn(name = "id")
public class SoldCar extends Car {
    private String customerName;

    private boolean g3ProtectionRequired;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone="Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateRequired;

    private String valetComments;

    private String workshopComments;

    private boolean polishMachineRequired;

    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;
    @ElementCollection(targetClass = WorkshopJobsOptions.class)
    @Enumerated(EnumType.STRING)
    private Set<WorkshopJobsOptions> workshopJobsOptions;

    public Set<WorkshopJobsOptions> getWorkshopJobsOptions() {
        return workshopJobsOptions;
    }

    public void setWorkshopJobsOptions(Set<WorkshopJobsOptions> workshopJobsOptions) {
        this.workshopJobsOptions = workshopJobsOptions;
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

    public boolean getPolishMachineRequired() {
        return polishMachineRequired;
    }

    public void setPolishMachineRequired(boolean polishMachineRequired) {
        this.polishMachineRequired = polishMachineRequired;
    }

    public String getWorkshopComments() {
        return workshopComments;
    }

    public void setWorkshopComments(String workshopComments) {
        this.workshopComments = workshopComments;
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

    public boolean getG3ProtectionRequired() {
        return g3ProtectionRequired;
    }

    public void setG3ProtectionRequired(boolean g3ProtectionRequired) {
        this.g3ProtectionRequired = g3ProtectionRequired;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoldCar soldCar)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getCustomerName(), soldCar.getCustomerName())
                && Objects.equals(getG3ProtectionRequired(), soldCar.getG3ProtectionRequired())
                && Objects.equals(getDateRequired(), soldCar.getDateRequired())
                && Objects.equals(getValetComments(), soldCar.getValetComments())
                && Objects.equals(getWorkshopComments(), soldCar.getWorkshopComments())
                && Objects.equals(getPolishMachineRequired(), soldCar.getPolishMachineRequired())
                && getCarStatus() == soldCar.getCarStatus()
                && getJobStatus() == soldCar.getJobStatus()
                && Objects.equals(getWorkshopJobsOptions(), soldCar.getWorkshopJobsOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCustomerName(), getG3ProtectionRequired(), getDateRequired(), getValetComments(),
                getWorkshopComments(), getPolishMachineRequired(), getCarStatus(), getJobStatus(), getWorkshopJobsOptions());
    }

    @Override
    public String toString() {
        return "SoldCar{" +
                "customerName='" + customerName + '\'' +
                ", g3ProtectionRequired=" + g3ProtectionRequired +
                ", dateRequired=" + dateRequired +
                ", valetComments='" + valetComments + '\'' +
                ", workshopComments='" + workshopComments + '\'' +
                ", polishMachineRequired=" + polishMachineRequired +
                ", carStatus=" + carStatus +
                ", jobStatus=" + jobStatus +
                ", workshopJobsOptions=" + workshopJobsOptions +
                '}';
    }
}
