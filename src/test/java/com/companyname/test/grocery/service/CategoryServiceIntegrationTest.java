package com.companyname.test.grocery.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.companyname.grocery.config.ServiceConfiguration;
import com.companyname.grocery.domain.Category;
import com.companyname.grocery.service.CategoryService;
import com.companyname.test.grocery.utils.CategoryUtils;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class CategoryServiceIntegrationTest {
	@Autowired
	private CategoryService service;	
	
	@After
	public void cleanUp() {
		service.deleteByName(CategoryUtils.PARENT_CAT_NAME_1);
		service.deleteByName(CategoryUtils.CHILD_CAT_NAME_1_1);
		service.deleteByName(CategoryUtils.CHILD_CAT_NAME_1_2);
	}
	
	@Test
	public void testCreateParent(){
		Category category = CategoryUtils.getNewCategory(CategoryUtils.PARENT_CAT_NAME_1, null);
		category = service.create(category);
		assertNotNull(String.format("Category [%s] has not been created", CategoryUtils.PARENT_CAT_NAME_1), category.getId());
	}
	
	@Test
	public void testCreateParentWithMultipleChildren() {
		Category parent = CategoryUtils.getNewCategory(CategoryUtils.PARENT_CAT_NAME_1, null);
		parent = service.create(parent);
		Category childA = CategoryUtils.getNewCategory(CategoryUtils.CHILD_CAT_NAME_1_1, parent.getId());
		childA = service.create(childA);
		Category childB = CategoryUtils.getNewCategory(CategoryUtils.CHILD_CAT_NAME_1_2, parent.getId());
		childB = service.create(childB);
		
		assertNotNull(String.format("Child Category [%s] has not been created", CategoryUtils.CHILD_CAT_NAME_1_1), childA.getParentId());
		assertNotNull(String.format("Child Category [%s] has not been created", CategoryUtils.CHILD_CAT_NAME_1_2), childB.getParentId());
		assertEquals(String.format("Expecting a 2 children for parent [%s] category", CategoryUtils.PARENT_CAT_NAME_1), 2, service.getChildren(childA.getParentId()).size());
	}
	
	public void testGetCategoryTree() {
		Category parent1 = CategoryUtils.getNewCategory(CategoryUtils.PARENT_CAT_NAME_1, null);
		parent1 = service.create(parent1);
		Category parent2 = CategoryUtils.getNewCategory(CategoryUtils.PARENT_CAT_NAME_2, null);
		Category parent3 = CategoryUtils.getNewCategory(CategoryUtils.PARENT_CAT_NAME_3, null);
	}
}
