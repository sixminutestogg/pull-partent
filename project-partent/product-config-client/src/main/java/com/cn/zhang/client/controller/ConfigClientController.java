package com.cn.zhang.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class ConfigClientController {

   //从git中的product-application-config.yml中获取相应的参数信息

   @Value("${spring.application.name}")
   private String applicationName;


   @Value("${server.port}")
   private String port;


   @RequestMapping("/config")
   public  String config(){

      String content = "applicationName:"+applicationName+"prot:"+port;
      System.out.println("content:"+content);
      return  content;
   }

}
