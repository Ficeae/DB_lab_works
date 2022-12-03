package org.example.controller;

import org.example.domain.Delivery;

import java.util.Date;
import java.util.Optional;

public interface DeliveryController extends GeneralController<Delivery, Integer> {
    Optional<Delivery> findByOrderTime(String ordered_time);
}
