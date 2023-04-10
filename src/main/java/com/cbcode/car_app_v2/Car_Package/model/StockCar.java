package com.cbcode.car_app_v2.Car_Package.model;

import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.Enums.WorkshopJobsOptions;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stock_car")
@PrimaryKeyJoinColumn(name = "id")
public class StockCar extends Car {
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

    public boolean isPolishMachineRequired() {
        return polishMachineRequired;
    }

    public void setPolishMachineRequired(boolean polishMachineRequired) {
        this.polishMachineRequired = polishMachineRequired;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockCar stockCar)) return false;
        if (!super.equals(o)) return false;
        return isPolishMachineRequired() == stockCar.isPolishMachineRequired()
                && Objects.equals(getValetComments(), stockCar.getValetComments())
                && Objects.equals(getWorkshopComments(), stockCar.getWorkshopComments())
                && getCarStatus() == stockCar.getCarStatus()
                && getJobStatus() == stockCar.getJobStatus()
                && Objects.equals(getWorkshopJobsOptions(), stockCar.getWorkshopJobsOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValetComments(), getWorkshopComments(), isPolishMachineRequired(), getCarStatus(), getJobStatus(), getWorkshopJobsOptions());
    }

    @Override
    public String toString() {
        return "StockCar{" +
                "valetComments='" + valetComments + '\'' +
                ", workshopComments='" + workshopComments + '\'' +
                ", polishMachineRequired=" + polishMachineRequired +
                ", carStatus=" + carStatus +
                ", jobStatus=" + jobStatus +
                ", workshopJobsOptions=" + workshopJobsOptions +
                '}';
    }
}
