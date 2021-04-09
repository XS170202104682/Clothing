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
public class Clothes {

    int id;
    int number;
    String name;
    String size;
    String brand;
    BigDecimal price;
    String color;
    String type;
    String material;
    String quantity;
    String img_name;
}
