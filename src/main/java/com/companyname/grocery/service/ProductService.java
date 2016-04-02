package com.companyname.grocery.service;


import com.companyname.grocery.domain.Product;

public interface ProductService {
	Product create(Product product);
	
	void deleteByName(String name);
}
