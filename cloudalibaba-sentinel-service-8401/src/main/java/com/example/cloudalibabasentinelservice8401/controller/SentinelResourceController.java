package com.example.cloudalibabasentinelservice8401.controller;/**
 * @Author:zhoayu
 * @Date:2024/9/23 23:34
 * @Description:com.example.cloudalibabasentinelservice8401.controller
 * @version:1.0
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloudalibabasentinelservice8401.handler.CustomBlockHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SentinelResourceController
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/9/23
 */

@RestController
public class SentinelResourceController {

    @RequestMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerResource")
    public String byResource(){
        return "-----------正常访问";
    }

    public String handlerResource(BlockException e){
        return "-----------系统繁忙";
    }

    @RequestMapping("/byCustom")
    @SentinelResource(value = "byCustom", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handleException1")
    public String byCustom(){
        return "-----------正常访问";
    }

}
 