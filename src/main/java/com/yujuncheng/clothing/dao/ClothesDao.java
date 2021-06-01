package com.yujuncheng.clothing.dao;

import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClothesDao {

    /*
      * 查询服装
     */
    @Select("select * from clothes where cId = 1")
    List<Clothes> selectClothes();

    /*
     * 查询鞋子
     */
    @Select("select * from clothes where cId = 2")
    List<Clothes> selectShoes();

    /*
     * 查询内衣裤
     */
    @Select("select * from clothes where cId = 3")
    List<Clothes> selectUnderWear();

    /*
    *根据ID查找
     */
    @Select("select * from `clothes` where id = #{id}")
    Clothes selectById(@Param("id") int id);

    /*
    *删除
     */
    @Delete("delete from clothes where id = #{id}")
    int deleteClothes(@Param("id") int id);

    /*
    *修改服装
     */
    @Options(useGeneratedKeys =true, keyProperty = "id")
    @Update("update clothes set name = #{name}, number = #{number}," +
            "size = #{size}, brand = #{brand}, price = #{price}," +
            "color = #{color}, type = #{type}, material = #{material}," +
            "quantity = #{quantity} " +
            "where id = #{id}")
    int updateClothes(Clothes clothes);

    /*
    *新增服装
     */
    // 加Option，新增数据库以后才能够拿到主键ID
    @Options(useGeneratedKeys =true, keyProperty = "id")
    @Insert("insert into clothes (number, name, size, brand, price, color," +
            "type, material, quantity, img_name, cId)" +
            " values (#{number}, #{name}, #{size}, #{brand}, #{price}, #{color}," +
            " #{type}, #{material}, #{quantity}, #{img_name}, 1)")
    int addClothes(Clothes clothes);

    /*
     *新增鞋袜
     */
    // 加Option，新增数据库以后才能够拿到主键ID
    @Options(useGeneratedKeys =true, keyProperty = "id")
    @Insert("insert into clothes (number, name, size, brand, price, color," +
            "type, material, quantity, img_name, cId)" +
            " values (#{number}, #{name}, #{size}, #{brand}, #{price}, #{color}," +
            " #{type}, #{material}, #{quantity}, #{img_name}, 2)")
    int addShoes(Clothes clothes);

    /*
     *新增内衣裤
     */
    // 加Option，新增数据库以后才能够拿到主键ID
    @Options(useGeneratedKeys =true, keyProperty = "id")
    @Insert("insert into clothes (number, name, size, brand, price, color," +
            "type, material, quantity, img_name, cId)" +
            " values (#{number}, #{name}, #{size}, #{brand}, #{price}, #{color}," +
            " #{type}, #{material}, #{quantity}, #{img_name}, 3)")
    int addUnderWear(Clothes clothes);

    @Select("select * from `clothes` where cID = 1 and `name` like CONCAT('%',#{name},'%')")
    List<Clothes> findName(Clothes clothes);

    //模糊查询鞋子
    @Select("select * from `clothes` where cID = 2 and `name` like CONCAT('%',#{name},'%')")
    List<Clothes> findShoe(Clothes clothes);


    //模糊查询内衣裤
    @Select("select * from `clothes` where cID = 3 and `name` like CONCAT('%',#{name},'%')")
    List<Clothes> findUnderWear(Clothes clothes);

    //上传图片
    @Update("update `clothes` set img_name = #{img_name} where id = #{id}")
    int setImageUrl(ProductVO vo);


}
