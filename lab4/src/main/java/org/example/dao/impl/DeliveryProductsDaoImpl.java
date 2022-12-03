package org.example.dao.impl;

import org.example.dao.DeliveryProductsDao;
import org.example.domain.DeliveryProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class DeliveryProductsDaoImpl implements DeliveryProductsDao {
    private static final String FIND_ALL = "SELECT * FROM delivery_products";
    private static final String CREATE = "INSERT delivery_products(product_id, delivery_id, quantity, weight, price) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE delivery_products SET product_id=?, delivery_id=?, quantity=?, weight=?, price=? WHERE product_id=? AND delivery_id=?";
    private static final String DELETE = "DELETE FROM delivery_products WHERE product_id=? AND delivery_id=?";
    private static final String FIND_BY_DELIVERY = "SELECT * FROM delivery_products WHERE price=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DeliveryProducts> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(DeliveryProducts.class));
    }

    @Override
    public Optional<DeliveryProducts> findById(Pair<Integer, Integer> id) {
        return Optional.empty();
    }

    @Override
    public int create(DeliveryProducts deliveryProducts) {
        return jdbcTemplate.update(CREATE, deliveryProducts.getQuantity(), deliveryProducts.getWeight(), deliveryProducts.getPrice());
    }

    @Override
    public int update(Pair<Integer, Integer> id, DeliveryProducts deliveryProducts) {
        return jdbcTemplate.update(UPDATE, id.getFirst(), id.getSecond(), deliveryProducts.getPrice(), deliveryProducts.getWeight(), deliveryProducts.getQuantity());
    }

    @Override
    public int delete(Pair<Integer, Integer> id) {
        return jdbcTemplate.update(DELETE, id.getFirst(), id.getSecond());
    }

    @Override
    public List<Integer> findByDelivery(Integer delivery_id) {
        return jdbcTemplate.query(FIND_BY_DELIVERY, BeanPropertyRowMapper.newInstance(Integer.class), delivery_id);
    }
}