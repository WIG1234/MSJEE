package com.example.paymentservice.models;

import lombok.Data;
import lombok.ToString;


@Data
public class User {
    private Long Id;
    private String name;
    private String email;

}