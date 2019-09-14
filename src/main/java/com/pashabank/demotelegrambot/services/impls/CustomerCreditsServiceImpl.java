package com.pashabank.demotelegrambot.services.impls;

import com.pashabank.demotelegrambot.domain.CustomerCreditsEntity;
import com.pashabank.demotelegrambot.domain.CustomerCreditsView;
import com.pashabank.demotelegrambot.repositories.CustomerCreditsRepository;
import com.pashabank.demotelegrambot.services.CustomerCreditsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerCreditsServiceImpl implements CustomerCreditsService {

    private CustomerCreditsRepository customerCreditsRepository;

    public CustomerCreditsServiceImpl(CustomerCreditsRepository customerCreditsRepository) {
        this.customerCreditsRepository = customerCreditsRepository;
    }

    public List<CustomerCreditsView> findCustomerCreditsAmountByCustomerPhoneNumber(String customerPhoneNumber) throws Exception {
        Optional<CustomerCreditsEntity> creditsAmount = customerCreditsRepository.findCustomerCreditsAmountByCustomerPhoneNumber(customerPhoneNumber);
        if (creditsAmount.isPresent()) {
            return creditsAmount
                    .stream()
                    .map(customerCreditsEntity -> new CustomerCreditsView(customerCreditsEntity.getTotalCreditsAmountInAZN(),
                            customerCreditsEntity.getTotalCreditsAmountInUSD()))
                    .collect(Collectors.toList());
        } else {
            throw new Exception("Record not found");
        }
    }
}