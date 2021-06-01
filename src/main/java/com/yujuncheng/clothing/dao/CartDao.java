package com.yujuncheng.clothing.dao;

import com.yujuncheng.clothing.domain.Cart;
import com.yujuncheng.clothing.domain.CartVO;
import com.yujuncheng.clothing.domain.OrderVO;
import com.yujuncheng.clothing.service.CartService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartDao {

    //查询购物车
    @Select("select * from `cart` where cId = #{cId}")
    List<Cart> showCart(Integer cId);

    @Delete("delete from `cart` where id = #{id}")
    int deleteCart(@Param("id") int id);

    //存入购物车总价
    @Update("update `cart` set totalPrice = #{totalPrice} where cId = #{cId}")
    int addToOrder(CartVO cartVO);

    //查询某用户ID的购物车
    @Select("select * from `cart` where cId = #{cId}")
    List<Cart> cartById(Integer cId);

    //将购物车植入订单中
    @Insert("insert into `order` (number, name, price, quantity, img_name, color, brand, size, type, material, totalPrice, customerId) " +
            "select number, name, price, quantity, img_name, color, brand, size, type, material, totalPrice, cId" +
            " from `cart` where cId = #{cId}")
    int intoOrder(Integer cId);

    //根据id查服装数量
    @Select("select * from `cart` where id = #{id}")
    Cart selectQuantity(@Param("id") Integer id);

    //更新服装数量
    @Update("update `cart` set quantity = #{quantity} where id = #{id}")
    int reduceQuantity(CartVO cartVO);

    //下单后删除购物车
    @Delete("delete from `cart` where cId = #{cId}")
    int deleteAllCart(Integer cId);



}
