package com.cn.zhang.pro.service.impl;

import com.cn.zhang.model.Product;
import com.cn.zhang.pro.dao.ProductDao;
import com.cn.zhang.pro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;



    @Override
    public List<Product> list() {
        return productDao.list();
    }
}
