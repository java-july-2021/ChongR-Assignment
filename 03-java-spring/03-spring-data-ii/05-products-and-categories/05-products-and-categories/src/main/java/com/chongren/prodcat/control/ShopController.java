package com.chongren.prodcat.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chongren.prodcat.model.Category;
import com.chongren.prodcat.model.Product;
import com.chongren.prodcat.service.ShopService;

@Controller
public class ShopController {
		
	@Autowired
	ShopService sServ;
	
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
	public String newProduct(@ModelAttribute("Product")Product product, Model viewModel) {
		List<Category> allCategory = this.sServ.showAllCategory();
		viewModel.addAttribute("allCategory", allCategory);
		return "newproduct.jsp";
	}
	
	@PostMapping("/newproduct")
	public String processProduct(@Valid @ModelAttribute("Product")Product product, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			List<Category> allCategory = this.sServ.showAllCategory();
			viewModel.addAttribute("allCategory", allCategory);
//			return "newproduct.jsp";
		}
		this.sServ.createProduct(product);
		return "redirect:/";
	}
	
	
	//------------------------- New Category ------------------------//
	@GetMapping("/category/new")
	public String newCategory(Category category) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/newcategory")
	public String processCategory(@Valid @ModelAttribute("Category")Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		}
		this.sServ.createCategory(category);
		return "redirect:/";
	}
	
	
	//------------------------- Edit Product ------------------------//
	@GetMapping("/product/{id}")
	public String showProduct(@PathVariable("id")Long id, @ModelAttribute("product")Product product, Model viewModel) {
		viewModel.addAttribute("product", this.sServ.findProduct(id));
		return "showProduct.jsp";
	}
	
	@PostMapping ("/editproduct/{id}")
	public String processEditProduct(@Valid @ModelAttribute("product")Product product, @PathVariable("id")Long id, Model viewModel, BindingResult result) {
		if(result.hasErrors()) {
			viewModel.addAttribute("product", this.sServ.findProduct(id));
			return "showProduct.jsp";
		}
		this.sServ.updateProduct(product);
		return "redirect:/";
	}
	
	
	//------------------------- Edit Category ------------------------//
	@GetMapping("/category/{id}")
	public String showProduct(@PathVariable("id")Long id, @ModelAttribute("category")Category category, Model viewModel) {
		viewModel.addAttribute("category", this.sServ.findCategory(id));
		return "showCategory.jsp";
	}
	
	@PostMapping ("/editcategory/it")
	public String processEditCategory(@Valid @ModelAttribute("category")Category category, @PathVariable("id")Long id, Model viewModel, BindingResult result) {
		if(result.hasErrors()) {
			viewModel.addAttribute("category", this.sServ.findCategory(id));
			return "showCategory.jsp";
		}
		this.sServ.updateCategory(category);
		return "redirect:/";
	}
		
	


	//------------------------- Edit Category ------------------------//
	
//	//New Category
//	@GetMapping("/category/new")
//	public String newCategory(@PathVariablee("Category")Long id, Model viewModel) {
//		List<Product> allProd = this.sServ.showAllProduct();
//		viewModel.addAttribute("allProd", allProd);
//		return "newproduct.jsp";
//	}
//	
//	@PostMapping("/newcategory")
//	public String processCategory(@Valid @ModelAttribute("Product")Product product, BindingResult result, Model viewModel) {
//		if(result.hasErrors()) {
//			viewModel.addAttribute("allProd", allProd);
////			return "newcategory.jsp";
//		}
//		this.sServ.createCategory(category);
//		return "redirect:/";
//		
//	}
	
	

}
