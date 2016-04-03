package com.companyname.test.grocery.utils;

import java.util.Calendar;

import com.companyname.grocery.domain.Category;
import com.companyname.grocery.domain.Category.Status;

public class CategoryUtils {

	public final static String PARENT_CAT_NAME_1 = "TEST PARENT CATEGORY 1";

	public final static String CHILD_CAT_NAME_1_1 = "TEST CHILD CATEGORY 1.1";

	public final static String CHILD_CAT_NAME_1_2 = "TEST CHILD CATEGORY 1.2";

	public final static String PARENT_CAT_NAME_2 = "TEST PARENT CATEGORY 2";

	public final static String PARENT_CAT_NAME_3 = "TEST PARENT CATEGORY 3";

	public final static String CHILD_CAT_NAME_3_1 = "TEST PARENT CATEGORY 3.1";

	public final static String CHILD_CAT_NAME_3_1_1 = "TEST PARENT CATEGORY 3.1.1";

	public static Category getNewCategory(String name, Long parentId) {
		Category category = new Category();
		category.setName(name);
		category.setParentId(parentId);
		return category;
	}
	
	public static Category getNewActiveCategory(String name, Long parentId) {
		Category category = getNewCategory(name, parentId);
		category.setStatus(Status.ACTIVE);
		return category;
	}
}
