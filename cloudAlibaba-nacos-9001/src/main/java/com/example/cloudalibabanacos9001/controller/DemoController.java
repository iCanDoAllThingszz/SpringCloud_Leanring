package com.example.cloudalibabanacos9001.controller;/**
 * @Author:zhoayu
 * @Date:2024/8/12 13:11
 * @Description:com.example.cloudalibabanacos9001.controller
 * @version:1.0
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;

/**
 * @ClassName DemoController
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/8/12
 */

@RestController
public class DemoController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/demo/{id}")
    public String getServerPort(@PathVariable(name="id") Long id){
        if(id>=5) {
            throw new InvalidParameterException("id should be less than 5");
        }
        return "Hello Nacos Discovery " + serverPort + " " + id;
    }

    @GetMapping("/gateway")
    public String gateway(){
        return "gateway" + " " + serverPort;
    }

    @GetMapping("/gateway/param/{id}")
    public String gatewayParam(@PathVariable(name="id") Long id){
        return "gateway/parm" + id + " " + serverPort;
    }

    @GetMapping("/gateway2")
    public String gateway2(){
        return "gateway2" + " " + serverPort;
    }

    @GetMapping("/route")
    public String route(){
        return "gateway-route" + " " + serverPort;
    }

}

