package com.companyname.grocery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.grocery.domain.Product;
import com.companyname.grocery.repository.ProductRepository;
import com.companyname.grocery.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product create(Product product) {
		return new Product();
		//return productRepository.save(product);
	}

}
