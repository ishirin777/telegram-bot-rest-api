package com.pashabank.demotelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerView {

    private int AZN;
    private int USD;
    private int EUR;
    private int others;
}
