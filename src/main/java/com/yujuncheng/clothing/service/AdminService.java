package com.yujuncheng.clothing.service;

import com.yujuncheng.clothing.domain.Admin;
import org.apache.ibatis.annotations.Insert;

public interface AdminService {

    //注册
    @Insert("insert admin (name, phone, password) values (#{name}, #{phone}," +
            "#{password})")
    int register(Admin admin);

    //登录
    Admin login(String name, String password);

    Admin adminByUsername(String name);
}
