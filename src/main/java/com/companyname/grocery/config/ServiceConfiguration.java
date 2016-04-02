package com.companyname.grocery.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.companyname.grocery.service"})
@Import(value = {RepositoryConfiguration.class})
public class ServiceConfiguration {

}
