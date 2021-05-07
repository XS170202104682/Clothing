package com.yujuncheng.clothing.service.impl;

import com.yujuncheng.clothing.dao.OrderDao;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.Order;
import com.yujuncheng.clothing.domain.OrderVO;
import com.yujuncheng.clothing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> selectOrder() {
        return orderDao.selectOrder();
    }

    @Override
    public int deleteOrder(int id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public Order selectById(int id) {
        return orderDao.selectById(id);
    }

    @Override
    public List<Order> findOrder(Order order) {
        return orderDao.findOrder(order);
    }

    @Override
    public int insertPhone(OrderVO orderVO) {
        return orderDao.insertPhone(orderVO);
    }
}
