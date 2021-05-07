package com.yujuncheng.clothing.security;
import cn.hutool.core.util.ObjectUtil;
import com.yujuncheng.clothing.domain.Admin;
import com.yujuncheng.clothing.domain.Customer;
import com.yujuncheng.clothing.service.AdminService;
import com.yujuncheng.clothing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        //adimn
        if (ObjectUtil.isNotNull(adminService.adminByUsername(name))){
            Admin admin = adminService.adminByUsername(name);

            if (admin == null){
                throw new UsernameNotFoundException("用户不存在") ;
            }

            return new User(
                    admin.getName(),
                    passwordEncoder.encode(admin.getPassword()),
                    new ArrayList<>()
            );
        }

        //customer
        if (ObjectUtil.isNotNull(customerService.customerByUsername(name))){
            Customer customer = customerService.customerByUsername(name);

            if (customer == null){
                throw new UsernameNotFoundException("用户不存在") ;
            }

            return new User(
                    customer.getName(),
                    passwordEncoder.encode(customer.getPassword()),
                    new ArrayList<>()
            );
        }

        throw new BadCredentialsException("账号或密码错误");
    }
}
