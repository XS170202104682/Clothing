package com.yujuncheng.clothing.controller;

import com.yujuncheng.clothing.domain.Admin;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.Customer;
import com.yujuncheng.clothing.service.AdminService;
import com.yujuncheng.clothing.service.ClothesMainService;
import com.yujuncheng.clothing.service.CustomerService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Log4j2
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ClothesMainService clothesMainService;

    //管理员注册操作
    @RequestMapping("register")
    public String register(Admin admin) {
        adminService.register(admin);
        return "login";
    }

    //管理员登录操作
    @RequestMapping("login1")
    public String  login(@RequestParam("name") String name, @RequestParam("password") String password){
        System.out.println(name);
        Admin admin = adminService.login(name, password);
        return "index";
    }

    @RequestMapping("logout")
    public String logout(){
        return "index";
    }

    //用户登录操作
    @RequestMapping("customerLogin")
    public String customerLogin(Customer customer, Model model, HttpSession session) {
        if(customer != null){
            List<Clothes> list = clothesMainService.selectClothes();
            List<Clothes> shoe = clothesMainService.selectShoes();
            model.addAttribute("list",list);
            model.addAttribute("shoes",shoe);
            Customer ctr = customerService.login(customer);
            String n = customer.getName();
            System.out.println(ctr);
            if (ctr != null){
                session.setAttribute("ctr", ctr);
                session.setAttribute("name", ctr.getName());
            }
            return "redirect:showClothes";
        }else {
            return null;
        }
    }

    //用户注册操作
    @RequestMapping("customerRegister")
    public String customerRegister(Customer customer) {
        customerService.register(customer);
        return "nozari/login";
    }

    //用户注销
    @RequestMapping("ctrLogout")
    public String LogOut(Customer customer,HttpSession session,Model model){
        List<Clothes> list = clothesMainService.selectClothes();
        List<Clothes> shoe = clothesMainService.selectShoes();
        model.addAttribute("list",list);
        model.addAttribute("shoes",shoe);
        session.setAttribute("ctr",null);
        return "nozari/index";
    }



}
