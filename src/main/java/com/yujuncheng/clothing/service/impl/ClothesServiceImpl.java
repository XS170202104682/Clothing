package com.yujuncheng.clothing.service.impl;

import com.yujuncheng.clothing.dao.ClothesDao;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.ProductVO;
import com.yujuncheng.clothing.service.ClothesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService {

    @Autowired
    private ClothesDao clothesDao;

    @Override
    public List<Clothes> selectClothes() {
        return clothesDao.selectClothes();
    }

    @Override
    public List<Clothes> selectShoes() {
        return clothesDao.selectShoes();
    }

    @Override
    public List<Clothes> selectUnderWear() {
        return clothesDao.selectUnderWear();
    }

    @Override
    public Clothes selectById(int id) {
        return clothesDao.selectById(id);
    }

    @Override
    public int deleteClothes(int id) {
        return clothesDao.deleteClothes(id);
    }

    @Override
    public int updateClothes(Clothes clothes) {
        return  clothesDao.updateClothes(clothes);
    }

    @Override
    public int addClothes(Clothes clothes) {
        return clothesDao.addClothes(clothes);
    }

    @Override
    public int addShoes(Clothes clothes) {
        return clothesDao.addShoes(clothes);
    }

    @Override
    public int addUnderWear(Clothes clothes) {
        return clothesDao.addUnderWear(clothes);
    }

    @Override
    public List<Clothes> findName(Clothes clothes) {
        return clothesDao.findName(clothes);
    }

    @Override
    public List<Clothes> findShoe(Clothes clothes) {
        return clothesDao.findShoe(clothes);
    }

    @Override
    public List<Clothes> findUnderWear(Clothes clothes) {
        return clothesDao.findUnderWear(clothes);
    }

    @Override
    public int setImageUrl(ProductVO vo) {
        return clothesDao.setImageUrl(vo);
    }



}
