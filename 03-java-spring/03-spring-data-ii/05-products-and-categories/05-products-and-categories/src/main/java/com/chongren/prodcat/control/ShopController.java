package com.chongren.prodcat.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chongren.prodcat.model.Category;
import com.chongren.prodcat.model.Product;
import com.chongren.prodcat.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService sServ;
	
	//------------------------- Home Page -----------------------//
	@RequestMapping("/")
	public String index(Model viewModel) {
		List<Category> allCat = sServ.showAllCategory();
		List<Product> allProd = sServ.showAllProduct();
		viewModel.addAttribute("allCat", allCat);
		viewModel.addAttribute("allProd", allProd);
		return "index.jsp";
	}
	
	//------------------------- New Product ------------------------//
	@GetMapping("/product/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/newproduct")
	public String processProduct(@RequestParam("name") String name, @RequestParam("desc") String description, @RequestParam("price") Double price) {
		Product newProd = new Product(name, description, price);
		this.sServ.createProduct(newProd);
		return "redirect:/product/new";
	}
	
	
	//------------------------- New Category ------------------------//
	@GetMapping("/category/new")
	public String newCategory() {
		return "newcategory.jsp";
	}

	@PostMapping("/newcategory")
	public String processCategory(@RequestParam("cat") String category) {
		Category newCat = new Category();
		newCat.setName(category);
		this.sServ.createCategory(newCat);
		return "redirect:/category/new";
	}
	
	
	//------------------------- Edit Product ------------------------//
	
	@GetMapping("/product/{id}")
	public String showProduct(Model viewModel, @PathVariable("id")Long id) {
		Product productToShow = this.sServ.findProduct(id);
		viewModel.addAttribute("notInProd", this.sServ.findCatNotInProd(productToShow));
		viewModel.addAttribute("product", productToShow);
		return "showProduct.jsp";
	}
	
	@PostMapping ("/editproduct/{id}")
	public String addCatToProduct(@RequestParam("cats")Long id, @PathVariable("id")Long product_id) {
		Product ProductToAddTo = this.sServ.findProduct(product_id);
		Category CatToAdd = this.sServ.findCategory(id); //how do i know if i got duplicate Cats, 
		this.sServ.addCatToProd(CatToAdd, ProductToAddTo);
		return "redirect:/product/{id}";
	}
	
	
	
	//------------------------- Edit Category ------------------------//
	
	@GetMapping("/category/{id}")
	public String showCategory(Model viewModel, @PathVariable("id")Long id) {
		Category catToShow = this.sServ.findCategory(id);
		viewModel.addAttribute("notInCat", this.sServ.findProdNotInCat(catToShow));
		viewModel.addAttribute("category", catToShow);
		return "showCategory.jsp";
	}
	
	@PostMapping ("/editcategory/{id}")
	public String addProdToCategory(@RequestParam("prod")Long id, @PathVariable("id")Long category_id) {
		Category CatToAddTo = this.sServ.findCategory(category_id);
		Product ProdToAdd = this.sServ.findProduct(id);
		this.sServ.addProdToCat(CatToAddTo, ProdToAdd);
		return "redirect:/category/{id}";
	}
	

}
