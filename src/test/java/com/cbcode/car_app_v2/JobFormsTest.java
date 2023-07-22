package com.cbcode.car_app_v2;

import com.cbcode.car_app_v2.Enums.CarStatus;
import com.cbcode.car_app_v2.Enums.JobStatus;
import com.cbcode.car_app_v2.Enums.WorkshopJobsOptions;
import com.cbcode.car_app_v2.JobForms_Packages.model.JobForms;
import com.cbcode.car_app_v2.Sales_Packages.model.Sales;
import com.cbcode.car_app_v2.User_Packages.model.User;
import com.cbcode.car_app_v2.Valet_Packages.model.Valet;
import com.cbcode.car_app_v2.Workshop_Packages.model.Workshop;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertSame;



public class JobFormsTest {
    @Test
    public void testCreateJobForm() throws ParseException {
        JobForms jobForms = new JobForms();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateStr = "27-07-2023";
        Date date = formatter.parse(dateStr);

        Set<WorkshopJobsOptions> options = EnumSet.of(
                WorkshopJobsOptions.MOT,
                WorkshopJobsOptions.SERVICE);

        jobForms.setId(1L);
        jobForms.setBrand("BMW");
        jobForms.setModel("X5");
        jobForms.setColor("Black");
        jobForms.setRegNumber("ABC123");
        jobForms.setChassisNumber("123456789");
        jobForms.setKeysNumber(2);
        jobForms.setCustomerName("Marie");
        jobForms.setValetComments("No comments");
        jobForms.setWorkshopComments("No comments");
        jobForms.setG3ProtectionRequired(true);
        jobForms.setPolishMachineRequired(false);
        jobForms.setDateRequired(date);
        jobForms.setCarStatus(CarStatus.SOLD);
        jobForms.setJobStatus(JobStatus.STARTS);
        jobForms.setWorkshopJobsOptions(options);

        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setFirstName("John");
        mockUser.setLastName("Doe");
        mockUser.setEmail("john@email.com");
        mockUser.setPassword("password");

        jobForms.setUsers(mockUser);
        User retrievedUser = jobForms.getUsers();

        Sales mockSales = new Sales();
        mockSales.setId(jobForms.getId());
        mockSales.setBrand(jobForms.getBrand());
        mockSales.setModel(jobForms.getModel());
        mockSales.setColor(jobForms.getColor());
        mockSales.setRegNumber(jobForms.getRegNumber());
        mockSales.setChassisNumber(jobForms.getChassisNumber());
        mockSales.setKeysNumber(jobForms.getKeysNumber());
        mockSales.setCustomerName(jobForms.getCustomerName());
        mockSales.setJobStatus(jobForms.getJobStatus());
        mockSales.setDateRequired(jobForms.getDateRequired());
        mockSales.setCarStatus(jobForms.getCarStatus());
        mockSales.setDateHandover(jobForms.getDateRequired());
        mockSales.setUsers(mockUser);

        jobForms.setSales(mockSales);
        Sales retrievedSales = jobForms.getSales();

        Valet mockValet = new Valet();
        mockValet.setId(jobForms.getId());
        mockValet.setBrand(jobForms.getBrand());
        mockValet.setModel(jobForms.getModel());
        mockValet.setColor(jobForms.getColor());
        mockValet.setRegNumber(jobForms.getRegNumber());
        mockValet.setChassisNumber(jobForms.getChassisNumber());
        mockValet.setKeysNumber(jobForms.getKeysNumber());
        mockValet.setCustomerName(jobForms.getCustomerName());
        mockValet.setG3ProtectionRequired(jobForms.getG3ProtectionRequired());
        mockValet.setPolishMachineRequired(jobForms.getPolishMachineRequired());
        mockValet.setValetComments(jobForms.getValetComments());
        mockValet.setJobStatus(jobForms.getJobStatus());
        mockValet.setDateRequired(jobForms.getDateRequired());
        mockValet.setCarStatus(jobForms.getCarStatus());
        mockValet.setUsers(mockUser);

        jobForms.setValet(mockValet);
        Valet retrievedValet = jobForms.getValet();


        Workshop mockWorkshop = new Workshop();
        mockWorkshop.setId(jobForms.getId());
        mockWorkshop.setBrand(jobForms.getBrand());
        mockWorkshop.setModel(jobForms.getModel());
        mockWorkshop.setColor(jobForms.getColor());
        mockWorkshop.setRegNumber(jobForms.getRegNumber());
        mockWorkshop.setChassisNumber(jobForms.getChassisNumber());
        mockWorkshop.setKeysNumber(jobForms.getKeysNumber());
        mockWorkshop.setCustomerName(jobForms.getCustomerName());
        mockWorkshop.setWorkshopComments(jobForms.getWorkshopComments());
        mockWorkshop.setJobStatus(jobForms.getJobStatus());
        mockWorkshop.setDateRequired(jobForms.getDateRequired());
        mockWorkshop.setCarStatus(jobForms.getCarStatus());
        mockWorkshop.setWorkshopJobsOptions(jobForms.getWorkshopJobsOptions());
        mockWorkshop.setUsers(mockUser);

        jobForms.setWorkshop(mockWorkshop);
        Workshop retrievedWorkshop = jobForms.getWorkshop();

        assert(jobForms.getId() == 1L);
        assert(jobForms.getBrand().equals("BMW"));
        assert(jobForms.getModel().equals("X5"));
        assert(jobForms.getColor().equals("Black"));
        assert(jobForms.getRegNumber().equals("ABC123"));
        assert(jobForms.getChassisNumber().equals("123456789"));
        assert(jobForms.getKeysNumber() == 2);
        assert(jobForms.getCustomerName().equals("Marie"));
        assert(jobForms.getValetComments().equals("No comments"));
        assert(jobForms.getWorkshopComments().equals("No comments"));
        assert(jobForms.getG3ProtectionRequired());
        assert(!jobForms.getPolishMachineRequired());
        assert(jobForms.getDateRequired().equals(date));
        assert(jobForms.getCarStatus().equals(CarStatus.SOLD));
        assert(jobForms.getJobStatus().equals(JobStatus.STARTS));
        assert(jobForms.getWorkshopJobsOptions().equals(options));
        assertSame(mockUser, retrievedUser);
        assertSame(mockSales, retrievedSales);
        assertSame(mockValet, retrievedValet);
        assertSame(mockWorkshop, retrievedWorkshop);
    }
}
