package com.example.cloudalibabaconfig3377.controller;/**
 * @Author:zhoayu
 * @Date:2024/9/9 12:40
 * @Description:com.example.cloudalibabaconfig3377.controller
 * @version:1.0
 */


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/9/9
 */

@RestController
@RefreshScope // 支持从Nacos的动态刷新功能
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}

 