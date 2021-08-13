package com.chongren.prodcat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.prodcat.model.Category;
import com.chongren.prodcat.model.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);
    

//    Category findById(id);
    
    List<Category> findAll();
    
}
