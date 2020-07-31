package com.cn.zhang.pro.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix             //开启熔断支持
@EnableEurekaClient     //本服务启动后会自动注册到eureka注册中心
@SpringBootApplication
@MapperScan("com.cn.zhang.pro.sell.dao.*")
public class ProductSellApplacation {

    public static void main(String[] args) {

        SpringApplication.run(ProductSellApplacation.class,args);
    }
}
