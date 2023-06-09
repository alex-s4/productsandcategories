package com.alexproject.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexproject.productsandcategories.models.Category;
import com.alexproject.productsandcategories.models.Product;
import com.alexproject.productsandcategories.repositories.CategoryRepository;
import com.alexproject.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	public ProductRepository prodRepo;
	
	@Autowired
	public CategoryRepository catRepo;
	
	// Create
	public Product createProd(Product createdProd)
	{
		
		return prodRepo.save(createdProd);
	}
	
	// Read
	public List<Product> findAllProducts()
	{
		return prodRepo.findAll();
	}
	
	public Product findOneProduct(Long id)
	{
		return prodRepo.findProductById(id);
	}
	
	// Update
	public Product updateProd(Product updatedProd)
	{
		
		return prodRepo.save(updatedProd);
	}
	
	// Delete
	public void deleteProd(Long id)
	{
		
		prodRepo.deleteById(id);
	}
	
	
	// Other methods:
	// Add the product to this category's list of products
	public void addOneCategory(Product product, Category category)
	{
		product.getCategories().add(category);
		this.prodRepo.save(product);
	}
	
	// Retrieves a list of products a particular category does not belong to
	public List<Product> getAllProdNotInCat(Category category)
	{
		return prodRepo.findByCategoriesNotContains(category);
	}
	
}
