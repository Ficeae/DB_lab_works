package org.example.service;

import org.example.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService extends GeneralService<Product, Integer> {
    Optional<Product> findByName(String name);
    List<Product> findAvailable(Boolean is_available);
}
