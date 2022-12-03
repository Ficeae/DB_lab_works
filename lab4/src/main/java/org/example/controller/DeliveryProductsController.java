package org.example.controller;

import org.example.domain.DeliveryProducts;
import org.springframework.data.util.Pair;

import java.util.List;

public interface DeliveryProductsController extends GeneralController<DeliveryProducts, Pair<Integer, Integer>> {
    List<Integer> findByDelivery(Integer delivery_id);
}
