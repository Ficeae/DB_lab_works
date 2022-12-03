package org.example.controller.impl;

import org.example.controller.DeliveryProductsController;
import org.example.domain.DeliveryProducts;
import org.example.service.DeliveryProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryProductsControllerImpl implements DeliveryProductsController {

    @Autowired
    private DeliveryProductsService deliveryProductsService;

    @Override
    public List<Integer> findByDelivery(Integer id) {
        return deliveryProductsService.findByDelivery(id);
    }

    @Override
    public List<DeliveryProducts> findAll() {
        return deliveryProductsService.findAll();
    }

    @Override
    public Optional<DeliveryProducts> findById(Pair<Integer, Integer> id) {
        return deliveryProductsService.findById(id);
    }

    @Override
    public int create(DeliveryProducts deliveryProducts) {
        return deliveryProductsService.create(deliveryProducts);
    }

    @Override
    public int update(Pair<Integer, Integer> id, DeliveryProducts deliveryProducts) {
        return deliveryProductsService.update(id, deliveryProducts);
    }

    @Override
    public int delete(Pair<Integer, Integer> id) {
        return deliveryProductsService.delete(id);
    }
}