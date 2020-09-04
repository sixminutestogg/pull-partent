package com.cn.zhang.pro.dao;


import com.cn.zhang.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface ProductDao {


    public List<Product> list();
}
