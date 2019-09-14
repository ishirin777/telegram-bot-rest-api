package com.pashabank.demotelegrambot.services;

import com.pashabank.demotelegrambot.domain.CustomerChatIdEntity;
import com.pashabank.demotelegrambot.domain.CustomerChatIdView;

public interface CustomerChatIdService {
    CustomerChatIdEntity createCustomerChatIdAndPhoneNumber(CustomerChatIdEntity customerChatIdEntity);
    CustomerChatIdView getCustomerByCustomerChatId(Long customerChatId);
}
