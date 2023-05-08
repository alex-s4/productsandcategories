package com.alexproject.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexproject.productsandcategories.models.Category;
import com.alexproject.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	Category findCategoryById(Long categoryId);
	
	List<Category> findByProductsNotContains(Product product);
}
