package com.pashabank.demotelegrambot.controller;

import com.pashabank.demotelegrambot.domain.*;
import com.pashabank.demotelegrambot.services.CustomerAccountsService;
import com.pashabank.demotelegrambot.services.CustomerChatIdService;
import com.pashabank.demotelegrambot.services.CustomerCreditsService;
import com.pashabank.demotelegrambot.services.CustomerNameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class BotController {

    private CustomerAccountsService customerAccountsService;
    private CustomerCreditsService customerCreditsService;
    private CustomerNameService customerNameService;
    private CustomerChatIdService customerChatIdService;

    public BotController(CustomerAccountsService customerAccountsService, CustomerCreditsService customerCreditsService, CustomerNameService customerNameService, CustomerChatIdService customerChatIdService) {
        this.customerAccountsService = customerAccountsService;
        this.customerCreditsService = customerCreditsService;
        this.customerNameService = customerNameService;
        this.customerChatIdService = customerChatIdService;
    }

    @GetMapping("/customerAccounts/{customerPhoneNumber}")
    public List<CustomerView> findCustomerAccountsByCustomerPhoneNumber(@PathVariable String customerPhoneNumber) throws Exception {
        return customerAccountsService.findCustomerAccountsByCustomerPhoneNumber(customerPhoneNumber);
    }

    @GetMapping("/customerCreditsAmount/{customerPhoneNumber}")
    public List<CustomerCreditsView> findCustomerCreditsAmountByCustomerPhoneNumber(@PathVariable String customerPhoneNumber) throws Exception {
        return customerCreditsService.findCustomerCreditsAmountByCustomerPhoneNumber(customerPhoneNumber);
    }

    @GetMapping("/customerNameAndSurname/{customerPhoneNumber}")
    public List<CustomerNameAndSurnameView> findCustomerNameAndSurnameByCustomerPhoneNumber(@PathVariable String customerPhoneNumber) throws Exception {
        return customerNameService.findCustomerNameAndSurnameByCustomerPhoneNumber(customerPhoneNumber);

    }

    @GetMapping("/customer/{customerChatId}")
    public CustomerChatIdView getCustomerByCustomerChatId(@PathVariable Long customerChatId) {
        return customerChatIdService.getCustomerByCustomerChatId(customerChatId);

    }

    @PostMapping
    public CustomerChatIdEntity createCustomerChatIdAndPhoneNumber(@ModelAttribute CustomerChatIdEntity customerChatIdEntityAndPhoneNumber) {
        return customerChatIdService.createCustomerChatIdAndPhoneNumber(customerChatIdEntityAndPhoneNumber);
    }
}
