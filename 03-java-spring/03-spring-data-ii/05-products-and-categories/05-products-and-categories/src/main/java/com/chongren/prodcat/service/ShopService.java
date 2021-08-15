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
	private  ProductRepository pRepo;
	
	@Autowired
	private  CategoryRepository cRepo;
	
	
	//-------------Product--------------//
	
	//Create a product
	public Product createProduct(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
	
	//Find a product
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
	
	
	//----------------Cross-----------------//
	
	//Save a category to a product
	public void addCatToProd(Category category, Product product) {
		List<Category> exsitCat  = product.getCategories();
		exsitCat.add(category);
		this.pRepo.save(product);

	}
	
	//Save a product to a category
		public void addProdToCat(Category category, Product product) {
			List<Product> exsitProd  = category.getProducts();
			exsitProd.add(product);
			this.cRepo.save(category);

		}
	
	
	public List<Category> findCatNotInProd(Product product){
		
		return this.cRepo.findByProductsNotContains(product);
	}
	
	
	public List<Product> findProdNotInCat(Category category){
			
			return this.pRepo.findByCategoriesNotContains(category);
		}
	
    
}

