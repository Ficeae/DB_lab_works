package org.example.service;

import org.example.domain.DeliveryProducts;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

public interface DeliveryProductsService extends GeneralService<DeliveryProducts, Pair<Integer, Integer>> {
    List<Integer> findByDelivery(Integer delivery_id);
}
