package com.yujuncheng.clothing.dao;
import com.yujuncheng.clothing.domain.Admin;
import com.yujuncheng.clothing.domain.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminDao {

    //注册
    @Insert("insert admin (name, phone, password) values (#{name}, #{phone}," +
            "#{password})")
    int register(Admin admin);

    //登录
    @Select("select * from admin where name = #{name} and password = #{password}")
    Admin login(String name, String password);

    @Select("select * from admin where name = #{name}")
    Admin adminByUsername(String name);
}
