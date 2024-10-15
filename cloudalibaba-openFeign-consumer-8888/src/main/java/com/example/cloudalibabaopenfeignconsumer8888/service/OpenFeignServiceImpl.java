package com.example.cloudalibabaopenfeignconsumer8888.service;/**
 * @Author:zhoayu
 * @Date:2024/10/15 12:39
 * @Description:com.example.cloudalibabaopenfeignconsumer8888.service
 * @version:1.0
 */

import org.springframework.stereotype.Component;

/**
 * @ClassName OpenFeignServiceImpl
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/10/15
 */

@Component
public class OpenFeignServiceImpl implements OpenFeignService {
    @Override
    public String getServerPort(Long id) {
        return "500:降级处理方法";
    }
}
