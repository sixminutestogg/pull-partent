package com.cn.zhang.web.service;

import com.cn.zhang.model.Product;
import com.cn.zhang.web.config.Contains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;



    public List<Product> list() {
        return  restTemplate.getForObject(Contains.PRODUCT_SERVICE+"/list",List.class);
    }
}
