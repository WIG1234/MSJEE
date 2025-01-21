package com.example.donservice;

import com.example.donservice.config.GlobalConfig;
import com.example.donservice.entities.Don;
import com.example.donservice.repositories.DonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(GlobalConfig.class)
public class DonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDon(DonRepository donRepository) {
        return args -> {
            // Create an initial Don instance
            Don initialDon = new Don();
            initialDon.setOrganisationId(1L); // Set a valid organisation ID
            initialDon.setTitle("Initial Donation");
            initialDon.setDescription("This donation is auto-created when the application starts.");
            initialDon.setMontantToAchieve(5000.0);
            initialDon.setCurrentAmount(0.0);
            initialDon.setAchieved(false);

            // Save the initial Don to the repository
            donRepository.save(initialDon);
            System.out.println("Initial Don created: " + initialDon);
        };
    }
}
