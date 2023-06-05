package com.example.annotations.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyBeans {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
