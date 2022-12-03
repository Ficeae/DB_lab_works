package org.example.dao;

import org.example.domain.DeliveryProducts;
import org.springframework.data.util.Pair;

import java.util.List;

public interface DeliveryProductsDao extends GeneralDao<DeliveryProducts, Pair<Integer, Integer>> {
    List<Integer> findByDelivery(Integer delivery_id);
}
