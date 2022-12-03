package org.example.controller;

import org.example.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductController extends GeneralController<Product, Integer>{
    Optional<Product> findByName(String name);
    List<Product> findAvailable(Boolean is_available);
}
