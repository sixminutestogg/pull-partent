package com.cn.zhang.web.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义配置类
 */
@Configuration
public class ConfigBean {

    ///@LoadBalanced表示这个RestTemplate开启负载均衡，在调用服务提供者的接口时，
    //可使用 服务名称 替代真实IP地址。服务名称 就是服务提供者在application.yml中
    //配置的spring.application.name属性的值。

    //注入restTemplte
    @Bean
    @LoadBalanced
    public RestTemplate getRestApi(){
        return  new RestTemplate();
    }


    //切换rinbbon的负载均衡的策略
    @Bean
    public IRule myRule(){
        //逐个考察Server，如果Server被tripped了，则忽略，在选择其中ActiveRequestsCount最小的server
        //return  new BestAvailableRule();

        //在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server
       // return  new RetryRule();

        //在index上随机，选择index对应位置的server
        return  new  RandomRule();
    }
}
