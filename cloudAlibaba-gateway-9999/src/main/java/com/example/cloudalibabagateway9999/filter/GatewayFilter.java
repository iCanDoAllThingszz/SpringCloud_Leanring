package com.example.cloudalibabagateway9999.filter;/**
 * @Author:zhoayu
 * @Date:2024/10/23 19:27
 * @Description:com.example.filter
 * @version:1.0
 */

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName GatewayFiltr
 * @Description //Gateway 全局过滤器
 * @Author zhaoyu
 * @Date 2024/10/23
 */
@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    // @param  exchange 可以拿到对应的request和response
    // @param chain 过滤器链
    // @return 是否放行
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 请求发送到下游之前的处理
        String username = exchange.getRequest().getQueryParams().getFirst("username"); // 通过exchange获得请求的第一个参数(第一个参数需要是username)
        System.out.println("filter " + "username: " + username);

        if (username == null) {
            System.out.println("username can not be null, 请求被拒绝");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        // 放行
        return chain.filter(exchange).then(Mono.fromRunnable(() -> System.out.println("filter对响应生效"))); // 响应发送到客户端之前的处理
    }

    // 定义filter的顺序, 返回值是int值, 数字越小 优先级越高 filter的执行顺序越靠前
    @Override
    public int getOrder() {
        return 0;
    }
}

