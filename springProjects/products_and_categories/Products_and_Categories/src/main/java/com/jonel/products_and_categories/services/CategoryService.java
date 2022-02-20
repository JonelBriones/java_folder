package com.jonel.products_and_categories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonel.products_and_categories.models.Category;
import com.jonel.products_and_categories.models.Product;
import com.jonel.products_and_categories.models.User;
import com.jonel.products_and_categories.repositories.CategoryRepository;
import com.jonel.products_and_categories.repositories.ProductRepository;
import com.jonel.products_and_categories.repositories.UserRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired 
	private ProductService productS;
	
	@Autowired
	private UserRepository userRepo;
	
	public List<Category> all() {
		return categoryRepo.findAll();
	}
	
	//Passes all products that have not yet been place into a category
	public List<Category>allExcluding(List<Long> excludedProductsId) {
		
		if (excludedProductsId.size() == 0) {
			return this.all();
		}
		else {
			return categoryRepo.findByIdNotIn(excludedProductsId);
		}
		
	}
	
	public List<Category> productsAvailable(List<Long> product) {
		return categoryRepo.findByIdNotIn(product);
	}
	public List<Category> findAllProducts(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	

	public Category findId(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public Category update(Category category) {
		return categoryRepo.save(category);
	}

	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}
	
	
	public void addProduct(Category category,Product product) {
		List<Product> currentProducts = category.getProducts();
		currentProducts.add(product);
		categoryRepo.save(category);
	}
}
