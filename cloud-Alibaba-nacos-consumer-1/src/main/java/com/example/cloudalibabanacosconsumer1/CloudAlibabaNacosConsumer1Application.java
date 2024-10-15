package com.example.cloudalibabanacosconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosConsumer1Application.class, args);
    }

}
