package com.pashabank.demotelegrambot.services;

import com.pashabank.demotelegrambot.domain.CustomerAccountsView;
import com.pashabank.demotelegrambot.domain.CustomerNameAndSurnameView;

import java.util.List;

public interface CustomerAccountsService {
    List<CustomerAccountsView> findCustomerAccountsByCustomerPhoneNumber(String customerPhoneNumber);
    List<CustomerNameAndSurnameView> findCustomerNameAndSurnameByCustomerPhoneNumber(String customerPhoneNumber);
}
