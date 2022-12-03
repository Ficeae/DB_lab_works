package org.example.controller;

import org.example.domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopController extends GeneralController<Shop, Integer>{
    Optional<Shop> findByAdress(String adress);
    List<Shop> findByCity(String city);
}
