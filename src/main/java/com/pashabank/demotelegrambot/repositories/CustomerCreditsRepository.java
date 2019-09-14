package com.pashabank.demotelegrambot.repositories;

import com.pashabank.demotelegrambot.domain.CustomerCreditsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerCreditsRepository extends JpaRepository<CustomerCreditsEntity, String> {
    Optional<CustomerCreditsEntity> findCustomerCreditsAmountByCustomerPhoneNumber(String customerPhoneNumber);
}
