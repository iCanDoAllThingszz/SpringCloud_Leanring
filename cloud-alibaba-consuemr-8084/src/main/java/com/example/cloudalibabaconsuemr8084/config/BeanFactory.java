package com.example.cloudalibabaconsuemr8084.config;/**
 * @Author:zhoayu
 * @Date:2024/9/24 23:50
 * @Description:com.example.cloudalibabaconsuemr8084.config
 * @version:1.0
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName BeanFactory
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/9/24
 */

@Configuration
public class BeanFactory {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

 