package com.example.cloudalibabagateway9999.config;/**
 * @Author:zhoayu
 * @Date:2024/10/21 20:42
 * @Description:com.example.config
 * @version:1.0
 */

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GatewayConfig
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/10/21
 */
@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        //构建多个routes
//        RouteLocatorBuilder.Builder routes = builder.routes();
//        //配置路由的具体地址(第一个路由)
//        RouteLocator routeLocator = routes.route("gateway2-id", r -> r.path("/gateway2/**").uri("http://localhost:9001/nacos-provider")).build();
//        //配置路由的具体地址(第二个路由)
//        // routes.route("gateway3-id", r -> r.path("/gateway3/**").uri("http://localhost::9002/nacos-provider"));
//        return routeLocator;
//    }
}

 