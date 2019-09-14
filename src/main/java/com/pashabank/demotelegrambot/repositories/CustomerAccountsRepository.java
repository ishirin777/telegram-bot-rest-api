package com.pashabank.demotelegrambot.repositories;

import com.pashabank.demotelegrambot.domain.CustomerAccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerAccountsRepository extends JpaRepository<CustomerAccountsEntity, String> {
    Optional<CustomerAccountsEntity> findCustomerAccountsByCustomerPhoneNumber(String customerPhoneNumber);

    Optional<CustomerAccountsEntity> findCustomerNameAndSurnameByCustomerPhoneNumber(String customerPhoneNumber);

}
