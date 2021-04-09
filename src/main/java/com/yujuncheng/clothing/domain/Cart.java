package com.yujuncheng.clothing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    int id;
    int number;
    String name;
    BigDecimal price;
    String quantity;
    int cId;
}
