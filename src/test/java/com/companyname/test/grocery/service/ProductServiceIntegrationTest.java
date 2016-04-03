package com.companyname.test.grocery.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.companyname.grocery.config.ServiceConfiguration;
import com.companyname.grocery.domain.Product;
import com.companyname.grocery.service.CategoryService;
import com.companyname.grocery.service.ProductService;
import com.companyname.test.grocery.utils.CategoryUtils;
import com.companyname.test.grocery.utils.ProductUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class ProductServiceIntegrationTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	
	@Before
	public void setUp(){
		categoryService.create(CategoryUtils.getNewActiveCategory(CategoryUtils.PARENT_CAT_NAME_1, null));
	}

	@After
	public void cleanUp() {
		productService.deleteByName(ProductUtils.PRODUCT_NAME);
		categoryService.deleteByName(CategoryUtils.PARENT_CAT_NAME_1);
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setName(ProductUtils.PRODUCT_NAME);
		product.setCategory(categoryService.findByName(CategoryUtils.PARENT_CAT_NAME_1));
		product = productService.create(product);
		assertNotNull(String.format("Expecting a new id for product [%s]", ProductUtils.PRODUCT_NAME), product.getId());		
	}
}
