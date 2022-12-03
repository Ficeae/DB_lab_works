package org.example.controller;

import org.example.domain.Customer;

import java.util.Optional;

public interface CustomerController extends GeneralController<Customer, Integer> {
    Optional<Customer> findByPhone(String phone);
}
