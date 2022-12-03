package org.example.service.impl;

import org.example.dao.ShopDao;
import org.example.domain.Shop;
import org.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public List<Shop> findAll() {
        return shopDao.findAll();
    }

    @Override
    public Optional<Shop> findById(Integer id) {
        return shopDao.findById(id);
    }

    @Override
    public int create(Shop shop) {
        return shopDao.create(shop);
    }

    @Override
    public int update(Integer id, Shop shop) {
        return shopDao.update(id, shop);
    }

    @Override
    public int delete(Integer id) {
        return shopDao.delete(id);
    }

    @Override
    public Optional<Shop> findByAdress(String adress) {
        return shopDao.findByAdress(adress);
    }

    @Override
    public List<Shop> findByCity(String city) {
        return shopDao.findByCity(city);
    }
}
