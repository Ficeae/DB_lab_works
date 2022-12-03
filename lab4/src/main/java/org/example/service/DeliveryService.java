package org.example.service;

import org.example.domain.Delivery;

import java.util.Date;
import java.util.Optional;

public interface DeliveryService extends GeneralService<Delivery, Integer> {
    Optional<Delivery> findByOrderTime(String ordered_time);
}
