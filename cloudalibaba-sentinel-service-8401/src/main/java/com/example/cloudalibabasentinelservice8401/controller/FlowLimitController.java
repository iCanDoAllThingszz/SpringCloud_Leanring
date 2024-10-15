package com.example.cloudalibabasentinelservice8401.controller;/**
 * @Author:zhoayu
 * @Date:2024/9/13 12:29
 * @Description:com.example.cloudalibabasentinelservice8401.controller
 * @version:1.0
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Block;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName FlowLimitController
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/9/13
 */
@RestController
public class FlowLimitController {
    @Value("${config.info}")
    private String info;

    @GetMapping("/testA")
    public String testA() {
        return info + " " + "testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return info + " " + "testB";
    }

    @GetMapping("/testC")
    public String testC() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return info + " " + "testC";
    }

    //热点规则测试
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "hotkeyHandler")
    public String testHotKey(@RequestParam(value = "hotkey1", required = false) String hotkey1,
                             @RequestParam(value = "hotkey2", required = false) String hotkey2,
                             @RequestParam(value = "hotkey3", required = false) String hotkey3) {
        return info + " " + "testHotKey" + " " + hotkey1 + " " + hotkey2 + " " + hotkey3;
    }

    //sentinel限流时的异常处理, 业务代码出异常时, 不会走到这里
    public String hotkeyHandler(String hot1, String hot2, String hot3, BlockException ex) {
        return "热点参数" + hot1 + " " + hot2 + " " + hot3 + " 被限流, 请稍后再试";
    }

}

 