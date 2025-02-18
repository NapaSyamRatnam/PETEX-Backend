package com.petex.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // Allow requests from your frontend domain
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specified HTTP methods
            .allowedHeaders("*"); // Allow all headers
    }
}


