package com.example.cloudalibabasentinelservice8401.handler;/**
 * @Author:zhoayu
 * @Date:2024/9/23 23:50
 * @Description:com.example.cloudalibabasentinelservice8401.handler
 * @version:1.0
 */

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @ClassName CustomBlockHandler
 * @Description //限流异常处理类
 * @Author zhaoyu
 * @Date 2024/9/23
 */
public class CustomBlockHandler {
    public static String handleException1(BlockException blockException) {
        return "系统异常: 请重试 111";
    }

    public static String handleException2(BlockException blockException) {
        return "网络崩溃: 请重试 222";
    }
}

 