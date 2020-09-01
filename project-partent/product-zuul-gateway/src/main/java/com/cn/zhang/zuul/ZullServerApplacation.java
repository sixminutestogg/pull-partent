package com.cn.zhang.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy   //开启zull功能  （请求路由或者过滤）
@SpringBootApplication
public class ZullServerApplacation {

    public static void main(String[] args) {
        SpringApplication.run(ZullServerApplacation.class,args);
    }
}

