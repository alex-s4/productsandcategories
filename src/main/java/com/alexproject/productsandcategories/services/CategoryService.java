package com.alexproject.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexproject.productsandcategories.models.Category;
import com.alexproject.productsandcategories.models.Product;
import com.alexproject.productsandcategories.repositories.CategoryRepository;
import com.alexproject.productsandcategories.repositories.ProductRepository;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository catRepo;
	
	@Autowired
	public ProductRepository prodRepo;
	
	// Create
	public Category createCat(Category createdCat)
	{
		
		return catRepo.save(createdCat);
	}
	
	// Read
	public List<Category> findAllCategories()
	{
		return catRepo.findAll();
	}
	
	public Category findOneCategory(Long id)
	{
		return catRepo.findCategoryById(id);
	}
	
	// Update
	public Category updateCat(Category updatedCat)
	{
		
		return catRepo.save(updatedCat);
	}
	
	// Delete
	public void deleteCat(Long id)
	{
		
		catRepo.deleteById(id);
	}
	
	
	// Other methods:
	// Add the product to this category's list of products
	public Category addOneProduct(Category category, Product product)
	{
		category.getProducts().add(product);
		return catRepo.save(category);
	}
	
	
	
	
}
