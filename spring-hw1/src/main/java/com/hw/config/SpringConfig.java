package com.hw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.hw")
@PropertySource("points.property")
@PropertySource("path.property")
public class SpringConfig {
}
