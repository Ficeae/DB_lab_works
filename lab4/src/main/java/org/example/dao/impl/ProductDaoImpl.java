package org.example.dao.impl;

import org.example.dao.ProductDao;
import org.example.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ProductDaoImpl implements ProductDao {
    private static final String FIND_ALL = "SELECT * FROM product";
    private static final String CREATE = "INSERT product(shop_id, manufacturer, name, category, price, arrived, expired, is_available) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE product SET shop_id=?, manufacturer=?, name=?, category=?, price=?, arrived=?, expired=?, is_available=? WHERE id=?";
    private static final String DELETE = "DELETE FROM product WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM product WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM product WHERE name=?";
    private static final String FIND_BY_AVAILABLE = "SELECT * FROM product WHERE is_available=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public Optional<Product> findById(Integer id) {
        Optional<Product> product;
        try {
            product = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Product.class), id));
        } catch (EmptyResultDataAccessException e) {
            product = Optional.empty();
        }
        return product;
    }

    @Override
    public int create(Product product) {
        return jdbcTemplate.update(CREATE, product.getName(), product.getManufacturer(), product.getCategory(), product.getArrived(),
                product.getExpired(), product.getIs_available());
    }

    @Override
    public int update(Integer id, Product product) {
        return jdbcTemplate.update(UPDATE, product.getName(), product.getManufacturer(), product.getCategory(), product.getArrived(),
                product.getExpired(), product.getIs_available(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        Optional<Product> product;
        try {
            product = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Product.class), name));
        } catch (EmptyResultDataAccessException e) {
            product = Optional.empty();
        }
        return product;
    }

    @Override
    public List<Product> findAvailable(Boolean is_available) {
        return jdbcTemplate.query(FIND_BY_AVAILABLE, BeanPropertyRowMapper.newInstance(Product.class), is_available);
    }
}
