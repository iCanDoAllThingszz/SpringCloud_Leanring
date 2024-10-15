package com.example.cloudalibabaprovider9003.controller;/**
 * @Author:zhoayu
 * @Date:2024/9/24 23:36
 * @Description:com.example.cloudalibabaprovider9003.controller
 * @version:1.0
 */

import com.example.cloudalibabacommons.entity.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ClassName DataController
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/9/24
 */

@RestController
public class DataController {
    @Value("${server.port}")
    private String serverPort;

    //模仿数据库存储数据
    public static HashMap<Integer, String> dataMap = new HashMap<>();
    static {
        dataMap.put(11, "鼠标");
        dataMap.put(12, "键盘");
        dataMap.put(13, "耳机");
    }

    @GetMapping("/info/{id}")
    public JsonResult<String> doSql(@PathVariable("id") Integer id) {
        JsonResult<String> jsonResult = new JsonResult<>(200, "success, serverPort is " + serverPort + ":" + dataMap.get(id));
        return jsonResult;
    }
}

 