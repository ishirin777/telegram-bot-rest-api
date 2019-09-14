package com.pashabank.demotelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerCreditsView {

    private int totalCreditsAmountInAZN;
    private int totalCreditsAmountInUSD;
}
