package com.example.cloudalibabaconsuemr8084.controller;/**
 * @Author:zhoayu
 * @Date:2024/9/24 23:47
 * @Description:com.example.cloudalibabaconsuemr8084.controller
 * @version:1.0
 */

import com.example.cloudalibabacommons.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumeController
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/9/24
 */

@RestController
public class ConsumeController {
    //服务提供者URL
    @Value("${service-url.nacos-service-provider}")
    private String providerUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consume/fallback/{id}")
    public JsonResult<String> fallback(@PathVariable("id") Long id) {
        //通过ribbon发起远程访问, 访问9003/9004
        JsonResult<String> jsonResult = restTemplate.getForObject(providerUrl + "/info", JsonResult.class, id);
        return jsonResult;
    }
}
