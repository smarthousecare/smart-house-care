package com.house.care.config.client;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

import feign.RequestInterceptor;

public class OAuth2UserClientFeignConfiguration {

    @Bean(name = "userFeignClientInterceptor")
    public RequestInterceptor getUserFeignClientInterceptor(OAuth2AuthorizedClientService clientService) {

        return new UserFeignClientInterceptor(clientService);
    }
}
