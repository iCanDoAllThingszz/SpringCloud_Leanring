package com.example.cloudalibabaopenfeignconsumer8888.service;/**
 * @Author:zhoayu
 * @Date:2024/10/14 20:25
 * @Description:com.example.cloudalibabaopenfeignconsumer8888.service
 * @version:1.0
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName OpenFeignService
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/10/14
 */

@Service
//填写要远程调用的服务名称
@FeignClient(value="nacos-provider", fallback=OpenFeignServiceImpl.class)
public interface OpenFeignService {

    //此方法表示远程调用的接口
    @GetMapping(value = "/demo/{id}")
    public String getServerPort(@PathVariable(name = "id") Long id);

}

 