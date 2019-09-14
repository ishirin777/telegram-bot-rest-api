package com.pashabank.demotelegrambot.services.impls;

import com.pashabank.demotelegrambot.domain.CustomerAccountsEntity;
import com.pashabank.demotelegrambot.domain.CustomerView;
import com.pashabank.demotelegrambot.repositories.CustomerAccountsRepository;
import com.pashabank.demotelegrambot.services.CustomerAccountsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerAccountsServiceImpl implements CustomerAccountsService {

    private CustomerAccountsRepository customerAccountsRepository;

    public CustomerAccountsServiceImpl(CustomerAccountsRepository customerAccountsRepository) {
        this.customerAccountsRepository = customerAccountsRepository;
    }

    @Override
    public List<CustomerView> findCustomerAccountsByCustomerPhoneNumber(String customerPhoneNumber) throws Exception {
        Optional<CustomerAccountsEntity> singleCustomer = customerAccountsRepository.findCustomerAccountsByCustomerPhoneNumber(customerPhoneNumber);
        if (singleCustomer.isPresent()) {
            return singleCustomer
                    .stream()
                    .map(customerAccountsEntity -> new CustomerView(customerAccountsEntity.getAZN(), customerAccountsEntity.getUSD(),
                            customerAccountsEntity.getEUR(), customerAccountsEntity.getOthers()))
                    .collect(Collectors.toList());
        } else {
            throw new Exception("Record not found");
        }
    }
}
