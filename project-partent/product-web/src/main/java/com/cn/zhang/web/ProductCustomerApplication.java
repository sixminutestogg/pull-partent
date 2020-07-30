package com.cn.zhang.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //向服务中心进行注册
public class ProductCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCustomerApplication.class,args);

    }
}
