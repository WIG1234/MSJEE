package com.example.organisationservice;

import com.example.organisationservice.entities.Organisation;
import com.example.organisationservice.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
@EnableFeignClients
public class OrganisationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganisationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(OrganisationRepository organisationRepository) {
        return args -> {
            // Initialize Organisation
            Organisation organisation = new Organisation();
            organisation.setName("Example Organisation");
            organisation.setDescription("This is a sample organisation.");
            organisation.setContactEmail("contact@example.org");
            organisation.setPhoneNumber("+1234567890");
            organisation.setAddress("123 Example Street");
            organisation.setVerified(true);
            organisationRepository.save(organisation);

            // Initialize Don with Organisation ID
           // Don donation = new Don();
            //donation.setOrganisationId(organisation.getId()); // Use the ID of the created organisation
            //donation.setTitle("Initial Donation");
            //donation.setDescription("This donation is auto-created with an organisation.");
            //donation.setMontantToAchieve(5000.0);
            //donation.setCurrentAmount(0.0);
            //donation.setAchieved(false);
            //donRepository.save(donation);

            //System.out.println("Initial Organisation created: " + organisation);
            //System.out.println("Initial Don created: " + donation);
        };
    }
}