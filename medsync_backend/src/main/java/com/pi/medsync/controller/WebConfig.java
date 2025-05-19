package com.pi.medsync.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")            // todas as rotas
                .allowedOrigins("*")          // todas as origens
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH")
                .maxAge(3600);
    }
}
