package com.cn.zhang.pro.controller;


import com.cn.zhang.model.Product;
import com.cn.zhang.pro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public List<Product> list(){
       return productService.list();
    }

}
