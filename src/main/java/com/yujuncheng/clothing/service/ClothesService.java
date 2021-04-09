package com.yujuncheng.clothing.service;

import com.yujuncheng.clothing.domain.Clothes;

import java.util.List;


public interface ClothesService {

    /*
     * 查询所有服装
     */

    List<Clothes> selectAll();
}
