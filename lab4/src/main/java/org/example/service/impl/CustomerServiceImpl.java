package org.example.service.impl;

import org.example.dao.CustomerDao;
import org.example.domain.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    public int create(Customer customer) {
        return customerDao.create(customer);
    }

    @Override
    public int update(Integer id, Customer customer) {
        return customerDao.update(id, customer);
    }

    @Override
    public int delete(Integer id) {
        return customerDao.delete(id);
    }

    @Override
    public Optional<Customer> findByPhone(String phone) {
        return customerDao.findByPhone(phone);
    }
}
