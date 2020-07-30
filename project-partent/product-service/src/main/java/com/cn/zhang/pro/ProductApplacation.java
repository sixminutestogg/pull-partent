package com.cn.zhang.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient     //本服务启动后会自动注册到eureka注册中心
@SpringBootApplication
@MapperScan("com.cn.zhang.pro.dao.*")
public class ProductApplacation {

    public static void main(String[] args) {

        SpringApplication.run(ProductApplacation.class,args);
    }
}
