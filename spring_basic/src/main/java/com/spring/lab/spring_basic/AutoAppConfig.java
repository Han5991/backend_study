package com.spring.lab.spring_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
    basePackages = "com.spring.lab.spring_basic",
    excludeFilters = @ComponentScan.Filter(Configuration.class))
public class AutoAppConfig {

}

