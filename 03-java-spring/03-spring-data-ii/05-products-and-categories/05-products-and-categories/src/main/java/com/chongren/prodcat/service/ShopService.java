package com.chongren.prodcat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.prodcat.model.Category;
import com.chongren.prodcat.model.Product;
import com.chongren.prodcat.repository.CategoryRepository;
import com.chongren.prodcat.repository.ProductRepository;

@Service
public class ShopService {
	
	@Autowired
	ProductRepository pRepo;
	
	@Autowired
	CategoryRepository cRepo;
	
////	//Save category to product
//	public Category addCatToProd(Long categoryId, Long productId) {
//		Category thisCategory = cRepo.findById(categoryId);
//		Product thisProduct = pRepo.findById(productId);
//	    thisCategory.products.add(thisProduct);
//	    return cRepo.save(thisCategory);
//	}
	
	//-------------Product--------------//
	
	//Create a product
	public Product createProduct(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
	
	//Find Product
	public Product findProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//Update a product
	public Product updateProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	//Delete a product
	public void deleteProduct(Long id) {
		pRepo.deleteById(id);
	}
	
	//Show All Products
	public List<Product> showAllProduct(){
		return pRepo.findAll();
	}
	
	
	//-------------Category--------------//
	
	//Create a category
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	//Find a category
	public Category findCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	//Update a category
	public Category updateCategory(Category category) {
		return cRepo.save(category);
	}
	
	//Delete a category
	public void deleteCategory(Long id) {
		this.cRepo.deleteById(id);
	}
	
	//Show all category
	public List<Category> showAllCategory(){
		return cRepo.findAll();
	}
	
//	//----------------Cross-----------------//
//	
////	//Save a category to a product
////	public Category saveCatToProd(Category cid, Product pid) {
////		Category thisCat = cRepo.findById(cid);
////		Product thisProd = pRepo.findById(pid);
////		
//////		Category cat = this.findCategory(cid);  //
//////		Product prod = this.findProduct(pid);    //
////		
////		
////		thisCat.getProducts().add(thisProd);
////		return cRepo.save(cid);
////	}
//	
    
}

