package com.companyname.grocery.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.companyname.grocery.service.*"})
public class ServiceConfiguration {

}
