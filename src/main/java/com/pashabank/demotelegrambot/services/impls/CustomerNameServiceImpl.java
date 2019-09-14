package com.pashabank.demotelegrambot.services.impls;

import com.pashabank.demotelegrambot.domain.CustomerAccountsEntity;
import com.pashabank.demotelegrambot.domain.CustomerNameAndSurnameView;
import com.pashabank.demotelegrambot.repositories.CustomerNameAndSurnameRepository;
import com.pashabank.demotelegrambot.services.CustomerNameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerNameServiceImpl implements CustomerNameService {

    CustomerNameAndSurnameRepository customerNameAndSurnameRepository;

    public CustomerNameServiceImpl(CustomerNameAndSurnameRepository customerNameAndSurnameRepository) {
        this.customerNameAndSurnameRepository = customerNameAndSurnameRepository;
    }

    public List<CustomerNameAndSurnameView> findCustomerNameAndSurnameByCustomerPhoneNumber(String customerPhoneNumber) throws Exception {

        Optional<CustomerAccountsEntity> customer = customerNameAndSurnameRepository
                .findCustomerNameAndSurnameByCustomerPhoneNumber(customerPhoneNumber);
        if (customer.isPresent()) {
            return customer
                    .stream()
                    .map(customerAccountsEntity -> new CustomerNameAndSurnameView(customerAccountsEntity.getCustomerName(), customerAccountsEntity.getCustomerSurname()))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
