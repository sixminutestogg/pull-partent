package com.cn.zhang.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.cn.zhang.web.service")
@SpringBootApplication
@EnableEurekaClient   //向服务中心进行注册
public class ProductCustomerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCustomerFeignApplication.class,args);

    }
}
