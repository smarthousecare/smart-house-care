package com.house.care.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FeignClient(name = "${spring.application.name}", configuration = FeignConfiguration.class)
public class FeignConfiguration {

    /**
     * Set the Feign specific log level to log client REST requests
     */
    @Bean
    feign.Logger.Level feignLoggerLevel() {

        return feign.Logger.Level.BASIC;
    }
}
