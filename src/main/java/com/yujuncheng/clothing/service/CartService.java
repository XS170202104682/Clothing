package com.yujuncheng.clothing.service;

import com.yujuncheng.clothing.domain.Cart;
import com.yujuncheng.clothing.domain.CartVO;
import com.yujuncheng.clothing.domain.OrderVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CartService {

    //查询购物车
    List<Cart> showCart(Integer cId);

    //删除购物车
    int deleteCart(@Param("id") int id);

    //存入购物车总价
    int addToOrder(CartVO cartVO);

    //查询某用户ID的购物车
    List<Cart> cartById(Integer cId);

    //将购物车植入订单中
    int intoOrder(Integer cId);

    //根据id查服装数量
    Cart selectQuantity(@Param("id") Integer id);

    //更新服装数量
    int reduceQuantity(CartVO cartVO);

    //下单后删除购物车
    int deleteAllCart(Integer cId);

}
