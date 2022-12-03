package org.example.controller.impl;

import org.example.controller.DeliveryController;
import org.example.domain.Delivery;
import org.example.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryControllerImpl implements DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Override
    public Optional<Delivery> findByOrderTime(String ordered_time) {
        return deliveryService.findByOrderTime(ordered_time);
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryService.findAll();
    }

    @Override
    public Optional<Delivery> findById(Integer id) {
        return deliveryService.findById(id);
    }

    @Override
    public int create(Delivery delivery) {
        return deliveryService.create(delivery);
    }

    @Override
    public int update(Integer id, Delivery delivery) {
        return deliveryService.update(id, delivery);
    }

    @Override
    public int delete(Integer id) {
        return deliveryService.delete(id);
    }
}