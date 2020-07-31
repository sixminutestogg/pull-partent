package com.cn.zhang.pro.sell.controller;


import com.cn.zhang.model.Product;
import com.cn.zhang.pro.sell.service.ProductSellService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductSellController {

    @Autowired
    private ProductSellService productSellService;


    @HystrixCommand(fallbackMethod = "getFallBack")
    @RequestMapping("/list")
    public List<Product> list(){
       return productSellService.list();
    }


    //当发发出现异常时调用
    public List<Product> getFallBack(){
        List<Product> list = new ArrayList<>();
        list.add(new Product(8002L,"熔断","hystrix"));
        return  list;
    }
}
