package com.cn.zhang.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义配置类
 */
@Configuration
public class ConfigBean {

    //注入restTemplte
    @Bean
    public RestTemplate getRestApi(){
        return  new RestTemplate();
    }
}
