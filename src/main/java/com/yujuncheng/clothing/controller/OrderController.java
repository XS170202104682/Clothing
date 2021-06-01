package com.yujuncheng.clothing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yujuncheng.clothing.domain.Order;
import com.yujuncheng.clothing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    //返还订单数据
    @ResponseBody
    @RequestMapping("order")
    public HashMap<String, Object> order(
            @RequestParam(defaultValue = "1",required = false) int page,
            @RequestParam(defaultValue = "10",required = false) int limit,
            @RequestParam(value = "phone",required = false) String phone,
            Order order
    ) {
        if (phone == null) {
            PageHelper.startPage(page, limit);
            List<Order> list = orderService.selectOrder();
            System.out.println(list);
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }else {
            PageHelper.startPage(page, limit);
            List<Order> list = orderService.findOrder(order);
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }

    }

    //跳转到订单页面
    @RequestMapping("toOrder")
    public String toOrder(){
        return "order";
    }

    //删除
    @RequestMapping("deleteOrder")
    @ResponseBody
    public String deleteOrder(@RequestParam("id") int id){
        orderService.deleteOrder(id);
        return "删除成功";
    }

    //弹出层编辑
    @RequestMapping("toUpdate")
    public String updateOrder(Model model, int id){
        Order order =orderService.selectById(id);
        model.addAttribute("id",id);
        model.addAttribute("number",order.getNumber());
        model.addAttribute("name",order.getName());
        model.addAttribute("size",order.getSize());
        model.addAttribute("brand",order.getBrand());
        model.addAttribute("price",order.getPrice());
        model.addAttribute("color",order.getColor());
        model.addAttribute("type",order.getType());
        model.addAttribute("material",order.getMaterial());
        model.addAttribute("quantity",order.getQuantity());
        model.addAttribute("img_name",order.getImg_name());
        model.addAttribute("customerId",order.getCustomerId());
        model.addAttribute("phone",order.getPhone());
        return "updateOrder";
    }

    //修改订单
    @RequestMapping("updateOrder")
    public String modifiedClothes(Order order){
        orderService.updateOrder(order);
        return "redirect:/order";
    }

}
