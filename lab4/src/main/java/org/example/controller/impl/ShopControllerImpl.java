package org.example.controller.impl;

import org.example.controller.ShopController;
import org.example.domain.Shop;
import org.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopControllerImpl implements ShopController {

    @Autowired
    private ShopService shopService;

    @Override
    public Optional<Shop> findByAdress(String adress) {
        return shopService.findByAdress(adress);
    }

    @Override
    public List<Shop> findByCity(String city) {
        return shopService.findByCity(city);
    }

    @Override
    public List<Shop> findAll() {
        return shopService.findAll();
    }

    @Override
    public Optional<Shop> findById(Integer id) {
        return shopService.findById(id);
    }

    @Override
    public int create(Shop shop) {
        return shopService.create(shop);
    }

    @Override
    public int update(Integer id, Shop shop) {
        return shopService.update(id, shop);
    }

    @Override
    public int delete(Integer id) {
        return shopService.delete(id);
    }
}