package com.example.cloudalibabanacosconsumer1.controller;/**
 * @Author:zhoayu
 * @Date:2024/8/13 21:37
 * @Description:com.example.cloudalibabanacosconsumer1.controller
 * @version:1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName DemoController
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/8/13
 */

@RestController
public class DemoController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer1")
    public String getDiscovery(){
        List<ServiceInstance> instances = discoveryClient.getInstances("nacos-provider");
        for (ServiceInstance serviceInstance : instances){
            System.out.println(serviceInstance.getHost()); //172.18.141.186
            System.out.println(serviceInstance.getPort()); //9001,9002
        }

        return restTemplate.getForObject("http://nacos-provider/demo/", String.class);
    }
}

