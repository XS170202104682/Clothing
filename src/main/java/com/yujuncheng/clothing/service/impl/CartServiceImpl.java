package com.yujuncheng.clothing.service.impl;

import com.yujuncheng.clothing.dao.CartDao;
import com.yujuncheng.clothing.domain.Cart;
import com.yujuncheng.clothing.domain.CartVO;
import com.yujuncheng.clothing.domain.OrderVO;
import com.yujuncheng.clothing.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public List<Cart> showCart(Integer cId) {
        return cartDao.showCart(cId);
    }

    @Override
    public int deleteCart(int id) {
        return cartDao.deleteCart(id);
    }

    @Override
    public int addToOrder(CartVO cartVO) {
        return cartDao.addToOrder(cartVO);
    }

    @Override
    public List<Cart> cartById(Integer id) {
        return cartDao.cartById(id);
    }

    @Override
    public int intoOrder(Integer cId) {
        return cartDao.intoOrder(cId);
    }

}
