package com.yujuncheng.clothing.dao;

import com.yujuncheng.clothing.domain.Clothes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClothesMainDao {

    /*
     * 查询服装
     */
    @Select("select * from `clothes` where cId = 1")
    List<Clothes> selectClothes();

    /*
     * 查询鞋袜
     */
    @Select("select * from `clothes` where cId = 2")
    List<Clothes> selectShoes();

    /*
     * 查询内衣裤
     */
    @Select("select * from `clothes` where cId = 3")
    List<Clothes> selectUnderWear();

    //查ID返回一个服装集合
    @Select("select * from `clothes` where id = #{id}")
    Clothes selectClotheById(@Param("id") Integer id);

    //将服装加入购物车
    @Insert("insert into `cart` (number,name,price,quantity,img_name,color,brand,size,type,material,cId)" +
            "values (#{number},#{name},#{price},#{quantity},#{img_name},#{color},#{brand},#{size},#{type},#{material},#{cId})")
    int addShopping(Clothes clothes);

    //模糊查询
    @Select("select * from `clothes` where name like CONCAT('%',#{name},'%')")
    List<Clothes> selectByName(String name);


}
