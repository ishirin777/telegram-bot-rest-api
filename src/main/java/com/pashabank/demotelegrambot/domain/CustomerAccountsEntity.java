package com.pashabank.demotelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_accounts")
public class CustomerAccountsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_username")
    private String customerUsername;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_surname")
    private String customerSurname;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "AZN")
    private int AZN;

    @Column(name = "USD")
    private int USD;

    @Column(name = "EUR")
    private int EUR;
}