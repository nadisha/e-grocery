package com.companyname.grocery.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.grocery.domain.Category;
import com.companyname.grocery.domain.Category.Status;
import com.companyname.grocery.repository.CategoryRepository;
import com.companyname.grocery.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository repository;
	
	public Category create(Category category) {
		return repository.save(category);
	}

	public Category update(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByName(String name) {
		Category category = repository.findByName(name);
		if (category != null) {
			repository.delete(category);
		}
	}

	public List<Category> getCategoryTree() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Category> getChildren(Long parentId) {
		Set<Category> children = repository.findByParentIdAndStatus(parentId, Status.ACTIVE);
		for (Category category : children) {
			category.setChildCategories(getChildren(category.getId()));
		}
		return children;
	}

}
