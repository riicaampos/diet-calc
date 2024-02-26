package com.dietcalc.configs;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
       return new ModelMapper();
    }
}
