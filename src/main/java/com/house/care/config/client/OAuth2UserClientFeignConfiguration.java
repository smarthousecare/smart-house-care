package com.house.care.config.client;

import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

public class OAuth2UserClientFeignConfiguration {

    @Bean(name = "userFeignClientInterceptor")
    public RequestInterceptor getUserFeignClientInterceptor() {

        return new UserFeignClientInterceptor();
    }
}
