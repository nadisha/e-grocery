package com.companyname.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companyname.grocery.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
