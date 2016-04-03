package com.companyname.grocery.service;

import java.util.Set;

import com.companyname.grocery.domain.Category;

public interface CategoryService {
	/**
	 * Default creates an inactive category
	 * @param category
	 * @return category in INACTIVE state
	 */
	Category create(Category category);

	Set<Category> getChildren(Long parentId);

	/**
	 * Consider only ACTIVE categories
	 */
	Set<Category> getCategoryTree();
	
	Category findByName(String name);

	Category update(Category category);

	void remove(Long id);

	/**
	 * Completely remove from the database
	 * 
	 * @param name
	 *            Name of a category
	 */
	void deleteByName(String name);
}
