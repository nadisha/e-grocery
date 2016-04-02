package com.technoura.grocery.service;

import java.util.List;

import com.technoura.grocery.domain.Product;

public interface ProductService {

	 List<Product> getAll();

	 Product add(Product product);

	 Product update(Product product);

	 Product getById(long id);

	 List<Product> getByCategory(long catId);

	 long delete(long id);
}
