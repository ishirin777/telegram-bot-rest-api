package com.pashabank.demotelegrambot.repositories;

import com.pashabank.demotelegrambot.domain.CustomerChatIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerChatIdRepository extends JpaRepository <CustomerChatIdEntity, Long> {
    Optional<CustomerChatIdEntity> getCustomerByCustomerChatId(Long customerChatId);
}
