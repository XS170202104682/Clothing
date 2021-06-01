package com.yujuncheng.clothing.controller;

import com.yujuncheng.clothing.domain.*;
import com.yujuncheng.clothing.service.CartService;
import com.yujuncheng.clothing.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CartConrtoller {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("toCart")
    public String toCart(Model model, HttpSession session){
        Customer customer = (Customer) session.getAttribute("ctr");
        //若未登录则进登录页面
        if (customer == null){
            return "nozari/login";
        }
        List<Cart> showCart = cartService.showCart(customer.getId());
        model.addAttribute("Cart",showCart);
        return "nozari/shoppingcart";
    }

    @RequestMapping("deleteCart")
    @ResponseBody
    public String deleteCart(@RequestParam("id") int id){
        try {
            cartService.deleteCart(id);
        } catch (Exception e) {
            return "null";
        }
        return "删除成功";
    }

    @RequestMapping("becomeOrder")
    public String becomeOrder(@Param("orderPrice") BigDecimal orderPrice,
                              HttpSession session){
        Customer customer = (Customer) session.getAttribute("ctr");
        CartVO cartVO = new CartVO();
        OrderVO orderVO = new OrderVO();
        Date oTime = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH: mm: ss");
        String current = simpleDateFormat.format(oTime);
        cartVO.setCId(customer.getId());
        cartVO.setTotalPrice(orderPrice);
        orderVO.setCustomerId(customer.getId());
        orderVO.setPhone(customer.getPhone());
        orderVO.setTime(current);
        cartService.addToOrder(cartVO);
        cartService.intoOrder(customer.getId());
        orderService.insertPhone(orderVO);
        cartService.deleteAllCart(customer.getId());
        return "nozari/checkout";
    }

    @RequestMapping("reduceQuantity")
    @ResponseBody
    public String reduceQuantity(@Param("id") int id){
        Cart carts = cartService.selectQuantity(id);
        CartVO cartVO = new CartVO();
        int quantity = carts.getQuantity();
        int quantity1;
        if (quantity == 1){
            cartService.deleteCart(id);
            return "删除服装";
        }else if (quantity >= 1){
            quantity1 = quantity-1;
            cartVO.setId(id);
            cartVO.setQuantity(quantity1);
            cartService.reduceQuantity(cartVO);
            return "减少成功";
        }else {
            return null;
        }
    }

    @RequestMapping("addQuantity")
    @ResponseBody
    public String addQuantity(@Param("id") int id){
        Cart carts = cartService.selectQuantity(id);
        CartVO cartVO = new CartVO();
        int quantity = carts.getQuantity();
        int quantity1;
        quantity1 = quantity+1;
        cartVO.setId(id);
        cartVO.setQuantity(quantity1);
        cartService.reduceQuantity(cartVO);
        return "增加成功";

    }


}
