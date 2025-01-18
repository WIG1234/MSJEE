package com.example.donservice;

import com.example.donservice.config.*;
import com.example.donservice.entities.Don;
import com.example.donservice.entities.UserDon;
import com.example.donservice.feign.UserRestClient;
import com.example.donservice.repositories.DonRepository;
import com.example.donservice.repositories.UserDonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(GlobalConfig.class)
public class DonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonServiceApplication.class, args);
    }

    }
