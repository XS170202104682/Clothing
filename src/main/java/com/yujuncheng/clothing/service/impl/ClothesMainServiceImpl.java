package com.yujuncheng.clothing.service.impl;

import com.yujuncheng.clothing.dao.ClothesMainDao;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.service.ClothesMainService;
import com.yujuncheng.clothing.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesMainServiceImpl implements ClothesMainService {

    @Autowired
    private ClothesMainDao clothesMainDao;

    @Override
    public List<Clothes> selectClothes() {
        return clothesMainDao.selectClothes();
    }

    @Override
    public List<Clothes> selectShoes() {
        return clothesMainDao.selectShoes();
    }

    @Override
    public List<Clothes> selectUnderWear() {
        return clothesMainDao.selectUnderWear();
    }

    @Override
    public Clothes selectClotheById(Integer id) {
        return clothesMainDao.selectClotheById(id);
    }

    @Override
    public int addShopping(Clothes clothes) {
        return clothesMainDao.addShopping(clothes);
    }

    @Override
    public List<Clothes> selectByName(String name) {
        return clothesMainDao.selectByName(name);
    }

}
