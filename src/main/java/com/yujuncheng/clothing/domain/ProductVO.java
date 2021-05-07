package com.yujuncheng.clothing.domain;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * 传入商品id和url封装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductVO {

    private int id;
    private String img_name;

}
