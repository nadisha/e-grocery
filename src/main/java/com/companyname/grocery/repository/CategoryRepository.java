package com.companyname.grocery.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companyname.grocery.domain.Category;
import com.companyname.grocery.domain.Category.Status;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String name);

	Set<Category> findByParentIdAndStatusOrderByNameAsc(Long parentId, Status status);
}
