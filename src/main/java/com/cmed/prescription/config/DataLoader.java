package com.cmed.prescription.config;

import com.cmed.prescription.model.User;
import com.cmed.prescription.model.Prescription;
import com.cmed.prescription.repository.UserRepository;
import com.cmed.prescription.service.PrescriptionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository userRepo, PasswordEncoder encoder, PrescriptionService pService) {
        return args -> {
            if (userRepo.findByUsername("admin").isEmpty()) {
                User u = new User("admin", encoder.encode("password"), "ROLE_USER");
                userRepo.save(u);
            }
            // sample prescriptions
            pService.save(sample(LocalDate.now().minusDays(2)));
            pService.save(sample(LocalDate.now()));
            pService.save(sample(LocalDate.now().minusDays(1)));
        };
    }

    private Prescription sample(LocalDate d) {
        Prescription p = new Prescription();
        p.setPrescriptionDate(d);
        p.setPatientName("John Doe");
        p.setPatientAge(35);
        p.setPatientGender("Male");
        p.setDiagnosis("Flu-like symptoms");
        p.setMedicines("Paracetamol 500mg, Rest");
        p.setNextVisitDate(d.plusDays(7));
        return p;
    }
}
