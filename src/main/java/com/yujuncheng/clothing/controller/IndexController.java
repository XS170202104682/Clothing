package com.yujuncheng.clothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {


    //主页
    @RequestMapping({"/","/index1"})
    public String index2(){
        return "index";
    }

    //前端界面
    @RequestMapping("index")
    public String index(){
        return "nozari/index";
    }

    //用户登陆
    @RequestMapping("toLogin")
    public String toLogin(){
        return "nozari/login";
    }

    //用户登陆
    @RequestMapping("toRegister")
    public String toRegister(){
        return "nozari/register";
    }

    //管理员注册
    @RequestMapping("adminRegister")
    public String adminRegister(){
        return "register";
    }

    //管理员登录
    @RequestMapping("adminLogin")
    public String adminLogin(){
        return "login";
    }




}
