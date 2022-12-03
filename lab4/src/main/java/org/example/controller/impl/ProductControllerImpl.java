package org.example.controller.impl;

import org.example.controller.ProductController;
import org.example.domain.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    public Optional<Product> findByName(String name) {
        return productService.findByName(name);
    }

    @Override
    public List<Product> findAvailable(Boolean is_available) {
        return productService.findAvailable(is_available);
    }

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productService.findById(id);
    }

    @Override
    public int create(Product product) {
        return productService.create(product);
    }

    @Override
    public int update(Integer id, Product product) {
        return productService.update(id, product);
    }

    @Override
    public int delete(Integer id) {
        return productService.delete(id);
    }
}