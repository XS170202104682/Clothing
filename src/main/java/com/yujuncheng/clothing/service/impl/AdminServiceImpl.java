package com.yujuncheng.clothing.service.impl;
import com.yujuncheng.clothing.dao.AdminDao;
import com.yujuncheng.clothing.domain.Admin;
import com.yujuncheng.clothing.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public int register(Admin admin) {
        return adminDao.register(admin);
    }

    @Override
    public Admin login(String name, String password) {
        return adminDao.login(name, password);
    }

    @Override
    public Admin adminByUsername(String name) {
        return adminDao.adminByUsername(name);
    }


}
