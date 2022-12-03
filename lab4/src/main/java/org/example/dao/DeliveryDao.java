package org.example.dao;

import org.example.domain.Delivery;

import java.util.Date;
import java.util.Optional;

public interface DeliveryDao extends GeneralDao<Delivery, Integer> {
    Optional<Delivery> findByOrderTime(String ordered_time);
}
