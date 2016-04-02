package com.technoura.grocery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoura.grocery.domain.Product;
import com.technoura.grocery.repository.ProductRepository;
import com.technoura.grocery.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAll() {
		return productRepository.findAll();
	}

	public Product add(Product product) {
		return productRepository.save(product);
	}

	public Product update(Product product) {
		return productRepository.save(product);
	}

	public Product getById(long id) {
		return productRepository.findOne(id);
	}

	public  List<Product>  getByCategory(long catId) {
		return productRepository.findAll();
	}
	
	public long delete(long id) {
		productRepository.delete(id);
		return id;
	}

}
