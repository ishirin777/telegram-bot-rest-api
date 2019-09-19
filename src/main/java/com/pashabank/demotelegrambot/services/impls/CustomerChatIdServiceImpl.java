package com.pashabank.demotelegrambot.services.impls;

import com.pashabank.demotelegrambot.domain.CustomerChatIdEntity;
import com.pashabank.demotelegrambot.domain.CustomerChatIdView;
import com.pashabank.demotelegrambot.repositories.CustomerChatIdRepository;
import com.pashabank.demotelegrambot.services.CustomerChatIdService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerChatIdServiceImpl implements CustomerChatIdService {

    private CustomerChatIdRepository customerChatIdRepository;

    public CustomerChatIdServiceImpl(CustomerChatIdRepository customerChatIdAndNumberRepository, CustomerChatIdRepository customerChatIdRepository) {
        this.customerChatIdRepository = customerChatIdAndNumberRepository;
        this.customerChatIdRepository = customerChatIdRepository;
    }

    @Override
    public CustomerChatIdEntity createCustomerChatIdAndPhoneNumber(CustomerChatIdEntity customerChatIdEntityAndPhoneNumber) {
        return customerChatIdRepository.save(customerChatIdEntityAndPhoneNumber);
    }

    @Override
    public CustomerChatIdView getCustomerByCustomerChatId(Long customerChatId) {
        Optional<CustomerChatIdEntity> customer = customerChatIdRepository.getCustomerByCustomerChatId(customerChatId);
        if (customer.isPresent()) {
            return customer
                    .stream()
                    .map(customerChatIdEntity -> new CustomerChatIdView(customerChatIdEntity.getCustomerPhoneNumber()))
                    .collect(Collectors.toList()).get(0);
        } else {
            return null;
        }
    }
}