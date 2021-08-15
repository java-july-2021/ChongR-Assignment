package com.chongren.prodcat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.prodcat.model.Category;
import com.chongren.prodcat.model.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	List<Category> findAll();  
	
    List<Category> findByProductsNotContains(Product product);
    
}
