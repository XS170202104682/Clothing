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
    List<Cart> cartById(Integer id);

    //将购物车植入订单中
    int intoOrder(Integer cId);

}
