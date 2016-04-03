package com.companyname.test.grocery.utils;

import com.companyname.grocery.domain.Category;
import com.companyname.grocery.domain.Product;

public class ProductUtils {
	public final static String PRODUCT_NAME = "TEST SAMPLE PRODUCT";
	
	public static Product getNewProduct(String productName, Category category) {
		Product product = new Product();
		product.setName(productName);
		product.setCategory(category);
		return product;
	}	
}
