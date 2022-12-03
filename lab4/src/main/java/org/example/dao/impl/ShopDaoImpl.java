package org.example.dao.impl;

import org.example.dao.ShopDao;
import org.example.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ShopDaoImpl implements ShopDao {
    private static final String FIND_ALL = "SELECT * FROM shop";
    private static final String CREATE = "INSERT shop(country, city, adress) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE shop SET country=?, city=?, adress=? WHERE id=?";
    private static final String DELETE = "DELETE FROM shop WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM shop WHERE id=?";
    private static final String FIND_BY_ADRESS = "SELECT * FROM shop WHERE adress=?";
    private static final String FIND_BY_CITY = "SELECT * FROM shop WHERE city=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Shop> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Shop.class));
    }

    @Override
    public Optional<Shop> findById(Integer id) {
        Optional<Shop> shop;
        try {
            shop = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Shop.class), id));
        } catch (EmptyResultDataAccessException e) {
            shop = Optional.empty();
        }
        return shop;
    }

    @Override
    public int create(Shop shop) {
        return jdbcTemplate.update(CREATE, shop.getCountry(), shop.getCity(), shop.getAdress());
    }

    @Override
    public int update(Integer id, Shop shop) {
        return jdbcTemplate.update(UPDATE, shop.getCountry(), shop.getCity(), shop.getAdress(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Shop> findByAdress(String adress) {
        Optional<Shop> shop;
        try {
            shop = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ADRESS,
                    BeanPropertyRowMapper.newInstance(Shop.class), adress));
        } catch (EmptyResultDataAccessException e) {
            shop = Optional.empty();
        }
        return shop;
    }

    @Override
    public List<Shop> findByCity(String city) {
        return jdbcTemplate.query(FIND_BY_CITY, BeanPropertyRowMapper.newInstance(Shop.class), city);
    }
}
