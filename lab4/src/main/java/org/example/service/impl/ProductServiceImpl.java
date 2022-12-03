package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.domain.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public int create(Product product) {
        return productDao.create(product);
    }

    @Override
    public int update(Integer id, Product product) {
        return productDao.update(id, product);
    }

    @Override
    public int delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public List<Product> findAvailable(Boolean is_available) {
        return productDao.findAvailable(is_available);
    }
}
