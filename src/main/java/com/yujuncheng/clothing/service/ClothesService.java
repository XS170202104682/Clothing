package com.yujuncheng.clothing.service;

import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.ProductVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ClothesService {

    /*
     * 查询服装
     */
    List<Clothes> selectClothes();

    /*
     * 查询鞋子
     */
    List<Clothes> selectShoes();

    /*
     * 查询内衣裤
     */
    List<Clothes> selectUnderWear();

    /*
     *根据ID查找
     */
    Clothes selectById(@Param("id") int id);

    /*
     *删除
     */
    int deleteClothes(@Param("id") int id);

    /*
    *修改
     */
    int updateClothes(Clothes clothes);

    /*
     *新增服装
     */
    int addClothes(Clothes clothes);

    /*
     *新增鞋袜
     */
    int addShoes(Clothes clothes);

    /*
     *新增内衣裤
     */
    int addUnderWear(Clothes clothes);

    //模糊查询
    List<Clothes> findName(Clothes clothes);

    //模糊查询鞋子
    List<Clothes> findShoe(Clothes clothes);


    //模糊查询内衣裤
    List<Clothes> findUnderWear(Clothes clothes);

    //上传文件
    int setImageUrl(ProductVO vo);

}
