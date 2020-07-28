package com.cn.zhang.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cn.zhang.pro.dao.*")
public class ProductApplacation {

    public static void main(String[] args) {

        SpringApplication.run(ProductApplacation.class);
    }
}
