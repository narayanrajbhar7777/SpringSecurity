package com.spring.security.confing;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSystem {

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
