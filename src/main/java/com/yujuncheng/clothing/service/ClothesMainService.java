package com.yujuncheng.clothing.service;

import com.yujuncheng.clothing.domain.Clothes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClothesMainService {

    /*
     * 查询服装
     */
    List<Clothes> selectClothes();


    /*
     * 查询鞋袜
     */
    List<Clothes> selectShoes();

    /*
     * 查询内衣裤
     */
    List<Clothes> selectUnderWear();

    //查ID返回一个服装集合
    Clothes selectClotheById(@Param("id") Integer id);

    //将服装加入购物车
    int addShopping(Clothes clothes);

    //模糊查询
    List<Clothes> selectByName(String name);


}
