package com.pashabank.demotelegrambot.services;

import com.pashabank.demotelegrambot.domain.CustomerView;

import java.util.List;

public interface CustomerAccountsService {
    List<CustomerView> findCustomerAccountsByCustomerPhoneNumber(String customerPhoneNumber) throws Exception;
}
