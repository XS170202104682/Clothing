package com.yujuncheng.clothing.service.impl;

import com.yujuncheng.clothing.dao.CustomerDao;
import com.yujuncheng.clothing.domain.Admin;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.Customer;
import com.yujuncheng.clothing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public int register(Customer customer) {
        return customerDao.register(customer);
    }

    @Override
    public Customer login(Customer customer) {
        return customerDao.login(customer);
    }

    @Override
    public List<Customer> selectCustomer() {
        return customerDao.selectCustomer();
    }

    @Override
    public Customer selectById(int id) {
        return customerDao.selectById(id);
    }

    @Override
    public int deleteCustomer(int id) {
        return customerDao.deleteCustomer(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public List<Customer> findCustomer(Customer customer) {
        return customerDao.findCustomer(customer);
    }

    @Override
    public Customer customerByUsername(String name) {
        return customerDao.customerByUsername(name);
    }
}
