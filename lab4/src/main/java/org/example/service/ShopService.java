package org.example.service;

import org.example.domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService extends GeneralService<Shop, Integer> {
    Optional<Shop> findByAdress(String adress);
    List<Shop> findByCity(String city);
}
