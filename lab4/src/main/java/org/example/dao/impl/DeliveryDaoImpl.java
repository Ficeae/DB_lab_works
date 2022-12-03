package org.example.dao.impl;

import org.example.dao.DeliveryDao;
import org.example.domain.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class DeliveryDaoImpl implements DeliveryDao {
    private static final String FIND_ALL = "SELECT * FROM delivery";
    private static final String CREATE = "INSERT delivery(customer_id, ordered_time, time, urgency_price) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE delivery SET customer_id=?, ordered_time=?, time=?, urgency_price=? WHERE id=?";
    private static final String DELETE = "DELETE FROM delivery WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM delivery WHERE id=?";
    private static final String FIND_BY_ORDER_TIME = "SELECT * FROM delivery WHERE ordered_time=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Delivery> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Delivery.class));
    }

    @Override
    public Optional<Delivery> findById(Integer id) {
        Optional<Delivery> delivery;
        try {
            delivery = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Delivery.class), id));
        } catch (EmptyResultDataAccessException e) {
            delivery = Optional.empty();
        }
        return delivery;
    }

    @Override
    public int create(Delivery delivery) {
        return jdbcTemplate.update(CREATE, delivery.getOrdered_time(), delivery.getTime(), delivery.getUrgency_price());
    }

    @Override
    public int update(Integer id, Delivery delivery) {
        return jdbcTemplate.update(UPDATE, delivery.getOrdered_time(), delivery.getTime(), delivery.getUrgency_price(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Delivery> findByOrderTime(String ordered_time) {
        Optional<Delivery> delivery;
        try {
            delivery = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ORDER_TIME,
                    BeanPropertyRowMapper.newInstance(Delivery.class), ordered_time));
        } catch (EmptyResultDataAccessException e) {
            delivery = Optional.empty();
        }
        return delivery;
    }
}