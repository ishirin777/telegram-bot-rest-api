package com.pashabank.demotelegrambot.controller;

import com.pashabank.demotelegrambot.domain.CustomerAccountsView;
import com.pashabank.demotelegrambot.domain.CustomerCreditsView;
import com.pashabank.demotelegrambot.domain.CustomerNameAndSurnameView;
import com.pashabank.demotelegrambot.services.CustomerAccountsService;
import com.pashabank.demotelegrambot.services.CustomerCreditsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class BotController {

    private CustomerAccountsService customerAccountsService;
    private CustomerCreditsService customerCreditsService;

    public BotController(CustomerAccountsService customerAccountsService, CustomerCreditsService customerCreditsService) {
        this.customerAccountsService = customerAccountsService;
        this.customerCreditsService = customerCreditsService;
    }

    @GetMapping("/customerAccounts/{customerPhoneNumber}")
    public List<CustomerAccountsView> findCustomerAccountsByCustomerPhoneNumber(@PathVariable String customerPhoneNumber) {
        return customerAccountsService.findCustomerAccountsByCustomerPhoneNumber(customerPhoneNumber);
    }

    @GetMapping("/customerCreditsAmount/{customerPhoneNumber}")
    public List<CustomerCreditsView> findCustomerCreditsAmountByCustomerPhoneNumber(@PathVariable String customerPhoneNumber) {
        return customerCreditsService.findCustomerCreditsAmountByCustomerPhoneNumber(customerPhoneNumber);
    }

    @GetMapping("/customerNameAndSurname/{customerPhoneNumber}")
    public CustomerNameAndSurnameView findCustomerNameAndSurnameByCustomerPhoneNumber(@PathVariable String customerPhoneNumber) {
        return customerAccountsService.findCustomerNameAndSurnameByCustomerPhoneNumber(customerPhoneNumber);
    }
}
