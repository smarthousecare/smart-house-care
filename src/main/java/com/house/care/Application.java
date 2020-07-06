package com.house.care;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.house.care.service.dto.SHCClientProperties;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableConfigurationProperties(SHCClientProperties.class)
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
