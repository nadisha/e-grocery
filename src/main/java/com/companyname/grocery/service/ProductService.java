package com.companyname.grocery.service;

import org.springframework.stereotype.Service;

import com.companyname.grocery.domain.Product;

public interface ProductService {
	Product create(Product product);
}
