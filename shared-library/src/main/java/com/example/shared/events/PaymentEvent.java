package com.example.shared.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEvent {
    private Long donationId;
    private Long userId;
    private double amount;
}
