package com.jonel.products_and_categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonel.products_and_categories.models.Category;
import com.jonel.products_and_categories.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByCategories(Category category);
	
    List<Product> findByCategoriesNotContains(Category category);
    
	List<Product> findAll();
	
}
