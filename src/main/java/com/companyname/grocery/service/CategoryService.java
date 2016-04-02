package com.companyname.grocery.service;

import java.util.List;
import java.util.Set;

import com.companyname.grocery.domain.Category;

public interface CategoryService {
	Category create(Category category);
	
	Set<Category> getChildren(Long parentId);
	
	List<Category> getCategoryTree();
	
	Category update(Category category);
	
	void remove(Long id);
	
	// Completely remove from the database
	void deleteByName(String name);
}
