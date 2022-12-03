package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DeliveryProducts {
    private Integer product_id;
    private Integer delivery_id;
    private Integer quantity;
    private Double weight;
    private Double price;
}
