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

    private Integer id;
    private Integer number;
    private String name;
    private String size;
    private String brand;
    private BigDecimal price;
    private String color;
    private String type;
    private String material;
    private Integer quantity;
    private String img_name;
    private Integer cId;
}
