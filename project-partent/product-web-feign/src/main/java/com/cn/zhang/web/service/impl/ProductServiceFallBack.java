package com.cn.zhang.web.service.impl;

import com.cn.zhang.model.Product;
import com.cn.zhang.web.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceFallBack implements ProductService {

    @Override
    public List<Product> list() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(999L,"feign熔断","feign-hystrix"));
        return  list;
    }
}
