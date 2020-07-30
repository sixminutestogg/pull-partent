package com.cn.zhang.web.service;

import com.cn.zhang.model.Product;
import com.cn.zhang.web.service.impl.ProductServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "product-service",fallback = ProductServiceFallBack.class)
public interface ProductService {

    @RequestMapping(value = "/product/list",method = RequestMethod.GET)
    public List<Product> list();
}
