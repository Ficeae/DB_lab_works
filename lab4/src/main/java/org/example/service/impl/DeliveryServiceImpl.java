package org.example.service.impl;

import org.example.dao.DeliveryDao;
import org.example.domain.Delivery;
import org.example.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    public List<Delivery> findAll() {
        return deliveryDao.findAll();
    }

    @Override
    public Optional<Delivery> findById(Integer id) {
        return deliveryDao.findById(id);
    }

    @Override
    public int create(Delivery delivery) {
        return deliveryDao.create(delivery);
    }

    @Override
    public int update(Integer id, Delivery delivery) {
        return deliveryDao.update(id, delivery);
    }

    @Override
    public int delete(Integer id) {
        return deliveryDao.delete(id);
    }

    @Override
    public Optional<Delivery> findByOrderTime(String ordered_time) {
        return deliveryDao.findByOrderTime(ordered_time);
    }
}
