package com.companyname.grocery.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.grocery.domain.Product;
import com.companyname.grocery.domain.Product.Status;
import com.companyname.grocery.repository.ProductRepository;
import com.companyname.grocery.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	public Product create(Product product) {
		// TODO : Check already exist products
		if (product.getStatus() == null) {
			product.setStatus(Status.INACTIVE);
		}
		product.setCreatedDate(DateTime.now().toDate());
		product.setLastModifiedDate(DateTime.now().toDate());
		return repository.save(product);
	}

	public void deleteByName(String name) {
		Product product = repository.findByName(name);
		if (product != null) {
			repository.delete(product);
		}
	}

}
