package com.example.cloudalibabanacosconsumer1.bean;/**
 * @Author:zhoayu
 * @Date:2024/8/13 21:33
 * @Description:com.example.cloudalibabanacosconsumer1.bean
 * @version:1.0
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName MyRestTemplate
 * @Description //TODO
 * @Author zhaoyu
 * @Date 2024/8/13
 */

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

