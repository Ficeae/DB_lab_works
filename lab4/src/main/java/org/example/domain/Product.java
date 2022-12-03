package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {
    private Integer id;
    private Integer shop_id;
    private String manufacturer;
    private String name;
    private String category;
    private Double price;
    private String arrived;
    private String expired;
    private Boolean is_available;
}
