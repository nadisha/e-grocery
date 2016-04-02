package com.companyname.test.grocery.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.companyname.grocery.config.EGroceryInitializer;
import com.companyname.grocery.config.RepositoryConfiguration;
import com.companyname.grocery.config.ServiceConfiguration;
import com.companyname.grocery.config.WebConfiguration;
import com.companyname.grocery.domain.Product;
import com.companyname.grocery.repository.ProductRepository;
import com.companyname.grocery.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class ProductServiceIntegrationTest {
	@Autowired
	private ProductService productService;
	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setName("Sample Product");
//		product = productService.create(product);
		
		//Assert.assertNull(product);
	}
}
