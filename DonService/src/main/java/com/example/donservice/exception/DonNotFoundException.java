package com.example.donservice.exception;


public class DonNotFoundException extends RuntimeException {
    public DonNotFoundException(String message) {
        super(message);
    }
}
