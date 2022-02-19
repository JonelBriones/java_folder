package com.jonel.products_and_categories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//...
@Entity
@Table(name="products")
public class Product {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotNull
 @Size(min=3, max=30, message="Name must be 3 to 30 characters!")
 private String name;
 @NotNull
 @Size(min=3,  max=255, message="Name must be 3 to 45 characters!")
 private String description;
// @Min(value=1, message="Too cheap at least a dollar!")
 @NotNull
 @Min(value=1, message="Must be at least one dollar")
 private float price;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 //Using n:m annotation to create relationship without extra entity/columns

 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
     name = "categories_products", 
     joinColumns = @JoinColumn(name = "product_id"), 
     inverseJoinColumns = @JoinColumn(name = "category_id")
 )
 private List<Category> categories;
 
 @ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="user_id")
 private User user;
 
 public Product() {
     
 }



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public float getPrice() {
	return price;
}



public void setPrice(float price) {
	this.price = price;
}



public Date getCreatedAt() {
	return createdAt;
}



public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}



public Date getUpdatedAt() {
	return updatedAt;
}



public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}



public List<Category> getCategories() {
	return categories;
}



public void setCategories(List<Category> categories) {
	this.categories = categories;
}



public User getUser() {
	return user;
}



public void setUser(User user) {
	this.user = user;
}



@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}

}

