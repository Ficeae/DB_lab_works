package org.example.service.impl;

import org.example.dao.DeliveryProductsDao;
import org.example.domain.DeliveryProducts;
import org.example.service.DeliveryProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryProductsServiceImpl implements DeliveryProductsService {
    @Autowired
    private DeliveryProductsDao deliveryProductsDao;

    @Override
    public List<DeliveryProducts> findAll() {
        return deliveryProductsDao.findAll();
    }

    @Override
    public Optional<DeliveryProducts> findById(Pair<Integer, Integer> id) {
        return deliveryProductsDao.findById(id);
    }

    @Override
    public int create(DeliveryProducts deliveryProducts) {
        return deliveryProductsDao.create(deliveryProducts);
    }

    @Override
    public int update(Pair<Integer, Integer> id, DeliveryProducts deliveryProducts) {
        return deliveryProductsDao.update(id, deliveryProducts);
    }

    @Override
    public int delete(Pair<Integer, Integer> id) {
        return deliveryProductsDao.delete(id);
    }

    @Override
    public List<Integer> findByDelivery(Integer delivery_id) {
        return deliveryProductsDao.findByDelivery(delivery_id);
    }
}
