package com.yujuncheng.clothing.service;

import com.yujuncheng.clothing.domain.Admin;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerService {
    //注册
    int register(Customer customer);

    //登录
    Customer login(Customer customer);

    /*
     * 查询用户
     */
    List<Customer> selectCustomer();


    /*
     *根据ID查找
     */
    Customer selectById(@Param("id") int id);

    /*
     *删除
     */
    int deleteCustomer(@Param("id") int id);

    /*
     *修改服装
     */
    int updateCustomer(Customer customer);

    /*
     *新增服装
     */
    int addCustomer(Customer customer);

    //模糊查询用户
    List<Customer> findCustomer(Customer customer);

    Customer customerByUsername(String name);
}
