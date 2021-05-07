package com.yujuncheng.clothing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private Integer id;
    private Integer number;
    private String name;
    private BigDecimal price;
    private String quantity;
    private Integer cId;
    private String img_name;
    private String color;
    private String brand;
    private String size;
    private String type;
    private String material;
    private BigDecimal totalPrice;
}
