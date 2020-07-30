package com.cn.zhang.pro.sell.controller;


import com.cn.zhang.model.Product;
import com.cn.zhang.pro.sell.service.ProductSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductSellController {

    @Autowired
    private ProductSellService productSellService;

    @RequestMapping("/list")
    public List<Product> list(){
       return productSellService.list();
    }

}
