package com.hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.text.DateFormat;

@Configuration
@ComponentScan("com.hw")
@PropertySource("classpath:application.property")
public class SpringConfig {
}
