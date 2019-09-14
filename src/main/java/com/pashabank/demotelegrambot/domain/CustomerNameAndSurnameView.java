package com.pashabank.demotelegrambot.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerNameAndSurnameView {

    private String customerName;
    private String customerSurname;
}
