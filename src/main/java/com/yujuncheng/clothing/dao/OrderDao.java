package com.yujuncheng.clothing.dao;


import com.yujuncheng.clothing.domain.Cart;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.Order;
import com.yujuncheng.clothing.domain.OrderVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDao {

    /*
     * 查询订单
     */
    @Select("select * from `order`")
    List<Order> selectOrder();

    /*
     *删除订单
     */
    @Delete("delete from `order` where id = #{id}")
    int deleteOrder(@Param("id") int id);

    /*
     *修改订单
     */
    @Update("update `order` set size = #{size}, color = #{color}," +
            "quantity = #{quantity} where id = #{id}")
    int updateOrder(Order order);

    /*
     *根据ID查找
     */
    @Select("select * from `order` where id = #{id}")
    Order selectById(@Param("id") int id);

    //模糊查询订单
    @Select("select * from `order` where `phone` like CONCAT('%',#{phone},'%')")
    List<Order> findOrder(Order order);

    //将用户手机存入订单中
    @Update("update `order` set phone = #{phone}, time = #{time} where customerId = #{customerId}")
    int insertPhone(OrderVO orderVO);
}
