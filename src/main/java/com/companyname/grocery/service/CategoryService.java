package com.companyname.grocery.service;

import java.util.Set;

import com.companyname.grocery.domain.Category;

public interface CategoryService {
	Category create(Category category);

	Set<Category> getChildren(Long parentId);

	/**
	 * Consider only ACTIVE categories
	 */
	Set<Category> getCategoryTree();

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
