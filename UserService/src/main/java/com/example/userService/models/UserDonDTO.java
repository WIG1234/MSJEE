package com.example.userService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDonDTO {
    private Long id;
    private String organisationName;
    private String Dontitle;
    private double amount;
    private LocalDate localDate;
}

