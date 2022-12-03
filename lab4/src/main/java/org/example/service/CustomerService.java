package org.example.service;

import org.example.domain.Customer;

import java.util.Optional;

public interface CustomerService extends GeneralService<Customer, Integer> {
    Optional<Customer> findByPhone(String phone);
}
