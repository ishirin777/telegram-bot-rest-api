package com.pashabank.demotelegrambot.services;

import com.pashabank.demotelegrambot.domain.CustomerCreditsView;

import java.util.List;

public interface CustomerCreditsService {
    List<CustomerCreditsView> findCustomerCreditsAmountByCustomerPhoneNumber(String customerPhoneNumber);
}
