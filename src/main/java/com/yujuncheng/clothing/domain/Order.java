package com.yujuncheng.clothing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Order {
    private Integer id;
    private Integer number;
    private String name;
    private BigDecimal price;
    private String quantity;
    private String size;
    private String brand;
    private String color;
    private String type;
    private String material;
    private String img_name;
    private Integer customerId;
    private String phone;
    private BigDecimal totalPrice;
}
