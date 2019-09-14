package com.pashabank.demotelegrambot.services.impls;

import com.pashabank.demotelegrambot.domain.CustomerAccountsEntity;
import com.pashabank.demotelegrambot.domain.CustomerAccountsView;
import com.pashabank.demotelegrambot.domain.CustomerNameAndSurnameView;
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
    public List<CustomerAccountsView> findCustomerAccountsByCustomerPhoneNumber(String customerPhoneNumber) throws Exception {
        Optional<CustomerAccountsEntity> singleCustomer = customerAccountsRepository.findCustomerAccountsByCustomerPhoneNumber(customerPhoneNumber);
        if (singleCustomer.isPresent()) {
            return singleCustomer
                    .stream()
                    .map(customerAccountsEntity -> new CustomerAccountsView(customerAccountsEntity.getAZN(), customerAccountsEntity.getUSD(),
                            customerAccountsEntity.getEUR(), customerAccountsEntity.getOthers()))
                    .collect(Collectors.toList());
        } else {
            throw new Exception("Record not found");
        }
    }

    @Override
    public List<CustomerNameAndSurnameView> findCustomerNameAndSurnameByCustomerPhoneNumber(String customerPhoneNumber) {
        Optional<CustomerAccountsEntity> customer = customerAccountsRepository
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
