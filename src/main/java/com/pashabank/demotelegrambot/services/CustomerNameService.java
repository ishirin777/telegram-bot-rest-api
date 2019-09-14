package com.pashabank.demotelegrambot.services;

import com.pashabank.demotelegrambot.domain.CustomerNameAndSurnameView;

import java.util.List;

public interface CustomerNameService {

    List<CustomerNameAndSurnameView> findCustomerNameAndSurnameByCustomerPhoneNumber (String customerPhoneNumber) throws Exception;
}
