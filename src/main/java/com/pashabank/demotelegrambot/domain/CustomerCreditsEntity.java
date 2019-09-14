package com.pashabank.demotelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_credits")
public class CustomerCreditsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "total_credits_amount_in_azn")
    private int totalCreditsAmountInAZN;

    @Column(name = "total_credits_amount_in_usd")
    private int totalCreditsAmountInUSD;
}
