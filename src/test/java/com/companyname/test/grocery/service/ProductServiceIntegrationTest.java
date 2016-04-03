package com.companyname.test.grocery.service;

import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.companyname.grocery.config.ServiceConfiguration;
import com.companyname.grocery.domain.Product;
import com.companyname.grocery.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class ProductServiceIntegrationTest {

	@Autowired
	private ProductService productService;

	private final static String PRODUCT_NAME = "TEST SAMPLE PRODUCT";

	@After
	public void cleanUp() {
		productService.deleteByName(PRODUCT_NAME);
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setName(PRODUCT_NAME);
		product = productService.create(product);
		assertNotEquals(0, product.getId());
	}
}
