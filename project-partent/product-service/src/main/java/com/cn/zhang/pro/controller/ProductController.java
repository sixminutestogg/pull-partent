package com.cn.zhang.pro.controller;


import com.cn.zhang.model.Product;
import com.cn.zhang.pro.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @HystrixCommand(fallbackMethod = "getFallBack")
    @RequestMapping("/list")
    public List<Product> list(){
         List<Product> list =   productService.list();
//         if(list.size()>0){
//             try {
//                 Thread.sleep(5000);
//                 throw  new RuntimeException("hystrix");
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
       return list;
    }

    //当发发出现异常时调用
    public  List<Product> getFallBack(){
        List<Product> list = new ArrayList<>();
        list.add(new Product(8001L,"熔断","hystrix"));
        return  list;
    }

}
