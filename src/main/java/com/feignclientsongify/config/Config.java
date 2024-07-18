package com.feignclientsongify.config;

import feign.Client;
import feign.codec.Decoder;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder();
    }

    @Bean
    public Client feignClient() {
        CloseableHttpClient httpClient = HttpClients.custom().build();
        return new ApacheHttpClient(httpClient);
    }
}
