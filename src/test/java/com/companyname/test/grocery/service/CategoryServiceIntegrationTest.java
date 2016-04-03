package com.companyname.test.grocery.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.companyname.grocery.config.ServiceConfiguration;
import com.companyname.grocery.domain.Category;
import com.companyname.grocery.domain.Category.Status;
import com.companyname.grocery.service.CategoryService;
import com.companyname.test.grocery.utils.CategoryUtils;

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
		service.deleteByName(CategoryUtils.PARENT_CAT_NAME_2);
		service.deleteByName(CategoryUtils.PARENT_CAT_NAME_3);
		service.deleteByName(CategoryUtils.CHILD_CAT_NAME_3_1);
		service.deleteByName(CategoryUtils.CHILD_CAT_NAME_3_1_1);
	}

	@Test
	public void testCreateParent() {
		Category category = CategoryUtils.getNewCategory(CategoryUtils.PARENT_CAT_NAME_1, null);
		category = service.create(category);
		assertNotNull(String.format("Category [%s] has not been created", CategoryUtils.PARENT_CAT_NAME_1),
				category.getId());
	}

	@Test
	public void testCreateParentWithMultipleChildren() {
		Category parent = createActiveCategory(CategoryUtils.PARENT_CAT_NAME_1, null);
		Category childA = createActiveCategory(CategoryUtils.CHILD_CAT_NAME_1_1, parent.getId());
		Category childB = createActiveCategory(CategoryUtils.CHILD_CAT_NAME_1_2, parent.getId());

		assertNotNull(String.format("Child Category [%s] has not been created", CategoryUtils.CHILD_CAT_NAME_1_1),
				childA.getParentId());
		assertNotNull(String.format("Child Category [%s] has not been created", CategoryUtils.CHILD_CAT_NAME_1_2),
				childB.getParentId());
		assertEquals(String.format("Expecting 2 children for parent [%s] category", CategoryUtils.PARENT_CAT_NAME_1), 2,
				service.getChildren(childA.getParentId()).size());
	}

	@Test
	/**
	 * The tree structure is. Parent 1 -> { Child 1.1, Child 1.2 }, Parent 2
	 * Parent 3 -> { Child 3.1 [ Child 3.1.1 ] }
	 */
	public void testGetCategoryTree() {
		Category parent1 = createActiveCategory(CategoryUtils.PARENT_CAT_NAME_1, null);
		createActiveCategory(CategoryUtils.CHILD_CAT_NAME_1_1, parent1.getId());
		createActiveCategory(CategoryUtils.CHILD_CAT_NAME_1_2, parent1.getId());

		createActiveCategory(CategoryUtils.PARENT_CAT_NAME_2, null);

		Category parent3 = createActiveCategory(CategoryUtils.PARENT_CAT_NAME_3, null);
		Category child3_1 = createActiveCategory(CategoryUtils.CHILD_CAT_NAME_3_1, parent3.getId());
		createActiveCategory(CategoryUtils.CHILD_CAT_NAME_3_1_1, child3_1.getId());

		Set<Category> tree = service.getCategoryTree();
		assertEquals("Expecting 3 parent level categories", 3, tree.size());
		assertEquals(String.format("Expecting 2 children for the first parent [%s]", CategoryUtils.PARENT_CAT_NAME_1),
				2, ((Category) tree.toArray()[0]).getChildCategories().size());
		assertEquals(String.format("Expecting no children for the second parent [%s]", CategoryUtils.PARENT_CAT_NAME_2),
				0, ((Category) tree.toArray()[1]).getChildCategories().size());
		Set<Category> children = ((Category) tree.toArray()[2]).getChildCategories();
		assertEquals(String.format("Expecting 1 child for the third parent [%s]", CategoryUtils.PARENT_CAT_NAME_3), 1,
				children.size());
		assertEquals(String.format("Expecting 1 child for the parent [%s]", CategoryUtils.CHILD_CAT_NAME_3_1), 1,
				((Category) children.toArray()[0]).getChildCategories().size());
	}

	private Category createActiveCategory(String name, Long parentId) {
		return service.create(CategoryUtils.getNewActiveCategory(name, parentId));
	}
}
