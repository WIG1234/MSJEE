package com.example.organisationservice.models;

import lombok.Data;


@Data
public class DonDTO {
    private Long id;
    private Long organisationId;
    private String title;
    private String description;
    private double montantToAchieve;
    private double currentAmount;
    private boolean isAchieved;
}