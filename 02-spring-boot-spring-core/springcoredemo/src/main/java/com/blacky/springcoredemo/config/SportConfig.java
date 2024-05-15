package com.blacky.springcoredemo.config;

import com.blacky.springcoredemo.common.Coach;
import com.blacky.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
