package com.yujuncheng.clothing.dao;

import com.yujuncheng.clothing.domain.Clothes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClothesDao {

    /*
      * 查询所有服装
     */
    @Select("select * from clothes")
    List<Clothes> selectAll();




}
