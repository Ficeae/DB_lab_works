package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Delivery {
    private Integer id;
    private Integer customer_id;
    private String ordered_time;
    private String time;
    private Double urgency_price;
}
