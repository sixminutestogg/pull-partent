package com.cn.zhang.pro.sell.dao;


import com.cn.zhang.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSellDao {


    public List<Product> list();
}
