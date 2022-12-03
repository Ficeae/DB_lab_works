package org.example.dao.impl;

import org.example.dao.CustomerDao;
import org.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CustomerDaoImpl implements CustomerDao {
    private static final String FIND_ALL = "SELECT * FROM customer";
    private static final String CREATE = "INSERT customer(name, surname, phone, adress) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE customer SET name=?, surname=?, phone=?, adress=? WHERE id=?";
    private static final String DELETE = "DELETE FROM customer WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM customer WHERE id=?";
    private static final String FIND_BY_PHONE = "SELECT * FROM customer WHERE phone=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Customer.class));
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        Optional<Customer> customer;
        try {
            customer = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Customer.class), id));
        } catch (EmptyResultDataAccessException e) {
            customer = Optional.empty();
        }
        return customer;
    }

    @Override
    public int create(Customer customer) {
        return jdbcTemplate.update(CREATE, customer.getPhone(), customer.getAdress(), customer.getName(), customer.getSurname());
    }

    @Override
    public int update(Integer id, Customer customer) {
        return jdbcTemplate.update(UPDATE, customer.getPhone(), customer.getAdress(), customer.getName(), customer.getSurname(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Customer> findByPhone(String phone) {
        Optional<Customer> customer;
        try {
            customer = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_PHONE,
                    BeanPropertyRowMapper.newInstance(Customer.class), phone));
        } catch (EmptyResultDataAccessException e) {
            customer = Optional.empty();
        }
        return customer;
    }
}