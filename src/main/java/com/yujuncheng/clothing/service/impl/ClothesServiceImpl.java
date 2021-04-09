package com.yujuncheng.clothing.service.impl;

import com.yujuncheng.clothing.dao.ClothesDao;
import com.yujuncheng.clothing.domain.Clothes;
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
    public List<Clothes> selectAll() {
        return clothesDao.selectAll();
    }
}
