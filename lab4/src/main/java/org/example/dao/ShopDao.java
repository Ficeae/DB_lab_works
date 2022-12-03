package org.example.dao;

import org.example.domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopDao extends GeneralDao<Shop, Integer>{
    Optional<Shop> findByAdress(String adress);
    List<Shop> findByCity(String city);
}
