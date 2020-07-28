package com.cn.zhang.web.controller;

import com.cn.zhang.model.Product;
import com.cn.zhang.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    ProductService productService;

    @RequestMapping("/list")
    public List<Product> list(){
        return productService.list();
    }
}
