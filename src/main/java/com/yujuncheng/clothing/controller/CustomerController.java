package com.yujuncheng.clothing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yujuncheng.clothing.domain.Customer;
import com.yujuncheng.clothing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //返还用户数据
    @ResponseBody
    @RequestMapping("customer")
    public HashMap<String, Object> customer(
            @RequestParam(defaultValue = "1",required = false) int page,
            @RequestParam(defaultValue = "10",required = false) int limit,
            @RequestParam(value = "name",required = false) String name,
            Customer customer
    ) {
        if(name == null){
            PageHelper.startPage(page, limit);
            List<Customer> list = customerService.selectCustomer();
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }else {
            PageHelper.startPage(page, limit);
            List<Customer> list = customerService.findCustomer(customer);
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }

    }

    //跳转到用户页面
    @RequestMapping("toCustomer")
    public String toCustomer(){
        return "customer";
    }

    //删除用户
    @RequestMapping("deleteCustomer")
    @ResponseBody
    public String deleteCustomer(@RequestParam("id") int id){
        customerService.deleteCustomer(id);
        return "删除成功";
    }

    //弹出层编辑
    @RequestMapping("toUpdateCustomer")
    public String updateCustomer(Model model, int id){
        Customer customer = customerService.selectById(id);
        model.addAttribute("id",id);
        model.addAttribute("name",customer.getName());
        model.addAttribute("phone",customer.getPhone());
        model.addAttribute("password",customer.getPassword());
        model.addAttribute("address",customer.getAddress());
        return "updateCustomer";
    }

    //修改服装
    @RequestMapping("updateCustomer")
    public String modifiedCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/customer";
    }

    //跳转到新增服装页面
    @RequestMapping("toAddCustomer")
    public String toAdd(){
        return "addCustomer";
    }

    //新增服装
    @RequestMapping("addCustomer")
    public String addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/customer";
    }
}
