package com.alexproject.productsandcategories.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexproject.productsandcategories.models.Category;
import com.alexproject.productsandcategories.models.Product;
import com.alexproject.productsandcategories.services.CategoryService;
import com.alexproject.productsandcategories.services.ProductService;

@Controller
public class ViewController {

	@Autowired
	CategoryService catServ;
	
	@Autowired
	ProductService prodServ;
	
	
	@GetMapping("/")
	public String index(Model mv)
	{
		List<Product> allProducts = prodServ.findAllProducts();
		List<Category> allCategories = catServ.findAllCategories();
		
		mv.addAttribute("products", allProducts);
		mv.addAttribute("categories", allCategories);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(Model mv)
	{
		mv.addAttribute("product", new Product());
		return "createProduct.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(Model mv)
	{
		mv.addAttribute("category", new Category());
		return "createCategory.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long productId, Model mv)
	{
		Product prodShown = prodServ.findOneProduct(productId);
		
		List<Category> allCategories = catServ.findAllCategories();
		List<Category> categoryOnProdShown = prodShown.getCategories();
		List<Category> catNotOnProd = catServ.getAllCatNotInProd(prodShown);
		
		mv.addAttribute("allCategories", allCategories);
		mv.addAttribute("product", prodShown);
		mv.addAttribute("categoriesOnProd", categoryOnProdShown);
		mv.addAttribute("categoriesNotOnProd", catNotOnProd);
		
		return "productPage.jsp";
	}
	
	@GetMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id") Long categoryId, Model mv)
	{
		Category catShown = catServ.findOneCategory(categoryId);
		
		List<Product> allProducts = prodServ.findAllProducts();
		List<Product> productOnCatShown = catShown.getProducts();
		List<Product> prodNotOnCat = prodServ.getAllProdNotInCat(catShown);
		
		mv.addAttribute("allProducts", allProducts);
		mv.addAttribute("category", catShown);
		mv.addAttribute("productsOnCat", productOnCatShown);
		mv.addAttribute("productsNotOnCat", prodNotOnCat);
		
		return "categoryPage.jsp";
	}
	
	@PostMapping("/createProduct")
	public String createNewProduct(@Valid @ModelAttribute("product") Product newProduct, BindingResult result, Model mv)
	{
		if(result.hasErrors())
		{
			return "createProduct.jsp";
		}
		else
		{
			mv.addAttribute("product", new Product());
			prodServ.createProd(newProduct);
			return "redirect:/products/new";
		}
	}
	
	@PostMapping("/createCategory")
	public String createNewCategory(@Valid @ModelAttribute("category") Category newCategory, BindingResult result, Model mv)
	{
		if(result.hasErrors())
		{
			return "createCategory.jsp";
		}
		else
		{
			mv.addAttribute("category", new Category());
			catServ.createCat(newCategory);
			return "redirect:/categories/new";
		}
	}
	
	@PutMapping("/products/{id}")
	public String addCatToProd(@Valid @ModelAttribute("existingProd") Product existingProd,
								BindingResult result,
								@RequestParam(value = "categories") Category category,
								Model mv)
	{
			prodServ.updateProd(existingProd);
			return "redirect:/products/"+existingProd.getId();
	}
	
	@PutMapping("/categories/{id}")
	public String addProdToCat(@Valid @ModelAttribute("existingCat") Category existingCat,
								BindingResult result,
								@RequestParam(value = "products") Product product,
								Model mv)
	{
			catServ.updateCat(existingCat);
			return "redirect:/categories/"+existingCat.getId();
	}
	
	
}
