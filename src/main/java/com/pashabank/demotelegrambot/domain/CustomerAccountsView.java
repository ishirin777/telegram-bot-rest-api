package com.pashabank.demotelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerAccountsView {

    private int AZN;
    private int USD;
    private int EUR;
}
