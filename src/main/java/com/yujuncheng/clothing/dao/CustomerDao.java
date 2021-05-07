package com.yujuncheng.clothing.dao;

import com.yujuncheng.clothing.domain.Admin;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerDao {

    //注册
    @Insert("insert customer (name, phone, password, address) values (#{name}, #{phone}," +
            "#{password}, #{address} )")
    int register(Customer customer);

    //登录
    @Select("select * from `customer` where name = #{name} and password = #{password}")
    Customer login(Customer customer);

    @Select("select name from `customer` where name = #{name} and password = #{password}")
    Customer loginName(Customer customer);


    /*
     * 查询用户
     */
    @Select("select * from customer")
    List<Customer> selectCustomer();

    /*
     *根据ID查找
     */
    @Select("select * from customer where id = #{id}")
    Customer selectById(@Param("id") int id);

    /*
     *删除用户
     */
    @Delete("delete from customer where id = #{id}")
    int deleteCustomer(@Param("id") int id);

    /*
     *修改用户
     */
    @Update("update `customer` set name = #{name}, phone = #{phone}," +
            "password = #{password}, address = #{address}"+
            "where id = #{id}")
    int updateCustomer(Customer customer);

    /*
     *新增用户
     */
    @Insert("insert into `customer` (name, phone, password, address)" +
            " values (#{name}, #{phone}, #{password}, #{address})")
    int addCustomer(Customer customer);

    //模糊查询用户
    @Select("select * from `customer` where `name` like CONCAT('%',#{name},'%')")
    List<Customer> findCustomer(Customer customer);

    @Select("select * from `customer` where name = #{name}")
    Customer customerByUsername(String name);
}
