package com.example.cloudalibabaopenfeignconsumer8888.controller;/**
 * @Author:zhoayu
 * @Date:2024/10/14 20:35
 * @Description:com.example.cloudalibabaopenfeignconsumer8888.controller
 * @version:1.0
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.cloudalibabaopenfeignconsumer8888.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OpenFeignController
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/10/14
 */

@RestController
public class OpenFeignController {
    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping(value = "/demo/{id}")
    public String getServerPort(@PathVariable("id") Long id){
        //自动实现负载均衡
        return openFeignService.getServerPort(id);
    }

    //测试看@SentinelResource注解的fallback属性和@FeignClient注解的fallback属性谁生效
    @GetMapping(value = "/demo2/{id}")
    @SentinelResource(value="getServerPort2", fallback="handleException")
    public String getServerPort2(@PathVariable("id") Long id){
        //自动实现负载均衡
        return openFeignService.getServerPort(id);
    }

    //测试看@SentinelResource注解的fallback属性能否生效
    @GetMapping(value = "/demo3/{id}")
    @SentinelResource(value="getServerPort3", fallback="handleException")
    public String getServerPort3(@PathVariable("id") Long id){
        //自动实现负载均衡
        return openFeignService.getServerPort(id);
    }

    public String handleException(Long id, Throwable ex){
        return "@SentinelResource fallback";
    }
}

 