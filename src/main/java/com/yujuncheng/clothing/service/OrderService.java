package com.yujuncheng.clothing.service;

import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.Order;
import com.yujuncheng.clothing.domain.OrderVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderService {

    /*
     * 查询订单
     */
    List<Order> selectOrder();

    /*
     *删除
     */
    int deleteOrder(@Param("id") int id);

    /*
     *修改订单
     */
    int updateOrder(Order order);

    /*
     *根据ID查找
     */
    Order selectById(@Param("id") int id);

    //模糊查询订单
    List<Order> findOrder(Order order);

    //将用户手机存入订单中
    int insertPhone(OrderVO orderVO);
}
