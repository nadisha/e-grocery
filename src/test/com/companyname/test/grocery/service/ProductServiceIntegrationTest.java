package com.companyname.test.grocery.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.companyname.grocery.config.ServiceConfiguration;
import com.companyname.grocery.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfiguration.class})
public class ProductServiceIntegrationTest {
	@Autowired
	private ProductService productService;
	
	
}
