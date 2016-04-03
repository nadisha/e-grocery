package com.companyname.grocery.service.impl;

import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.grocery.domain.Category;
import com.companyname.grocery.domain.Category.Status;
import com.companyname.grocery.repository.CategoryRepository;
import com.companyname.grocery.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category create(Category category) {
		// TODO : Need to check the category is already exist
		if (category.getStatus() == null) {
			category.setStatus(Status.INACTIVE);
		}		
		category.setCreatedDate(DateTime.now().toDate());
		category.setLastModifiedDate(DateTime.now().toDate());
		return repository.save(category);
	}
	
	public Set<Category> getChildren(Long parentId) {
		Set<Category> children = repository.findByParentIdAndStatusOrderByNameAsc(parentId, Status.ACTIVE);
		for (Category category : children) {
			category.setChildCategories(getChildren(category.getId()));
		}
		return children;
	}

	public Set<Category> getCategoryTree() {
		Set<Category> parents = repository.findByParentIdAndStatusOrderByNameAsc(null, Status.ACTIVE);
		for (Category p : parents) {
			p.setChildCategories(this.getChildren(p.getId()));
		}
		return parents;
	}

	public Category update(Category category) {
		category.setLastModifiedDate(DateTime.now().toDate());
		return repository.save(category);
	}

	public void remove(Long id) {
		repository.delete(repository.findOne(id));
	}

	public void deleteByName(String name) {
		Category category = repository.findByName(name);
		if (category != null) {
			repository.delete(category);
		}
	}

	public Category findByName(String name) {
		return repository.findByName(name);
	}



}
