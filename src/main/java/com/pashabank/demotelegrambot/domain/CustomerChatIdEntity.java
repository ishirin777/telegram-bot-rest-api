package com.pashabank.demotelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_chat_ids")
public class CustomerChatIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_chat_id")
    private Long customerChatId;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
