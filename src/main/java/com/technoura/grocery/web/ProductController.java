package com.technoura.grocery.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technoura.grocery.domain.Product;
import com.technoura.grocery.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final Logger logger = LoggerFactory.getLogger(ProductController.class); 
	
	@Autowired
    ProductService ProductService;
	
	@RequestMapping("/{pId}")
    public Product getProduct(@PathVariable long pId) {
 
		logger.debug("Enterted to {}",pId);
        return ProductService.getById(pId);
    }
	
	@RequestMapping(value="" , method=RequestMethod.POST,produces="application/json", consumes="application/json")
    public Product createProduct(@RequestBody Product p) {
		
		logger.debug("Saved Production   {}",p.getName());
        return ProductService.add(p);
    }
 

}
