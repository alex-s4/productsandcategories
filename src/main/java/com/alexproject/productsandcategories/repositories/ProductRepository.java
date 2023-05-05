package com.alexproject.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexproject.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findAll();
	
	Product findProductById(Long productId);
}
