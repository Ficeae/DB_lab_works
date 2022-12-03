package org.example.dao;

import org.example.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends GeneralDao<Product, Integer>{
    Optional<Product> findByName(String name);
    List<Product> findAvailable(Boolean is_available);
}
