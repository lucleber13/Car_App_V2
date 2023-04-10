package com.cbcode.car_app_v2;

import com.cbcode.car_app_v2.Valet_Packages.model.ValetCompleted;
import com.cbcode.car_app_v2.Valet_Packages.repository.ValetCompletedRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ValetCompletedServiceTest {

    @Autowired
    private ValetCompletedRepository valetCompletedRepository;

    @Test
    public void testDeleteValetCompleted() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenMinutesAgo = now.minusDays(6);
        LocalDateTime twentyMinutesAgo = now.minusDays(10);

        ValetCompleted valetCompleted1 = new ValetCompleted();
        valetCompleted1.setDateCreated(tenMinutesAgo);
        valetCompletedRepository.save(valetCompleted1);

        ValetCompleted valetCompleted2 = new ValetCompleted();
        valetCompleted2.setDateCreated(twentyMinutesAgo);
        valetCompletedRepository.save(valetCompleted2);



        valetCompletedRepository.deleteValetCompletedByDateCreatedBefore(now.minusDays(7));

        //assertEquals(1, valetCompletedRepository.findAll().size());
        assertTrue(valetCompletedRepository.findAll().contains(valetCompleted1));

        //valetCompletedRepository.deleteAll();

    }

}

