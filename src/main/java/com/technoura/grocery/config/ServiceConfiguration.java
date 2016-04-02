package com.technoura.grocery.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.technoura.grocery.service")
public class ServiceConfiguration {

}
