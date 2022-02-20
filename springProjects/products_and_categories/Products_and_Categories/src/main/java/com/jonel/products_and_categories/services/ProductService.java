package com.jonel.products_and_categories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonel.products_and_categories.models.Category;
import com.jonel.products_and_categories.models.Product;
import com.jonel.products_and_categories.models.User;
import com.jonel.products_and_categories.repositories.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
    public List<Product> all() {
        return productRepo.findAll();
    }
	
	public Product create(Product product) {
		return productRepo.save(product);
	}
	
	public Product update(Product product) {
		return productRepo.save(product);
	}
	
	public Product findId(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		productRepo.deleteById(id);
	}
	
	public void addCategory(Category category,Product product) {
		List<Category> currentCategory = product.getCategories();
		currentCategory.add(category);
		productRepo.save(product);
	}
}
