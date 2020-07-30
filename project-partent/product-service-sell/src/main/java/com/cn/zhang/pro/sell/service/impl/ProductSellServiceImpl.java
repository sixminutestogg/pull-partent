package com.cn.zhang.pro.sell.service.impl;

import com.cn.zhang.model.Product;
import com.cn.zhang.pro.sell.dao.ProductSellDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.zhang.pro.sell.service.ProductSellService;

import java.util.List;

@Service
public class ProductSellServiceImpl implements ProductSellService {


    @Autowired
    private ProductSellDao productDao;



    @Override
    public List<Product> list() {
        return productDao.list();
    }
}
