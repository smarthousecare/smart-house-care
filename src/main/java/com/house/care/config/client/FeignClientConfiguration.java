package com.house.care.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.Request;
import feign.codec.ErrorDecoder;
import feign.error.AnnotationErrorDecoder;

public class FeignClientConfiguration {

    @Value("${feign.client.config.default.connectTimeout}")
    private int connectTimeout;

    @Value("${feign.client.config.default.readTimeout}")
    private int readTimeout;

    @Bean
    public ErrorDecoder errorDecoder() {

        return AnnotationErrorDecoder.builderFor(FeignClientConfiguration.class).build();
    }

    @Bean
    public Request.Options options() {

        return new Request.Options(connectTimeout, readTimeout);
    }

    @Bean
    public Logger.Level loggerLevel() {

        return Logger.Level.FULL;
    }

    // @Bean(name = "requestTokenBearerInterceptor")
    // public RequestInterceptor requestTokenBearerInterceptor() {
    //
    // return requestTemplate -> {
    //
    // String token = SecurityUtils.getCurrentJwtToken();
    // requestTemplate.header("Authorization", "bearer " + token);
    // };
    // }

}
