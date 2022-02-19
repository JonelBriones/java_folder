package com.jonel.products_and_categories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//..
@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotNull
 @Size(min=3, max=30, message = "Name must be 3 to 30 characters long!")
 private String userName;
 
 @NotEmpty(message="Email is required!")
 @Email(message="Please enter a valid email!")
 private String email;
 
 // FOR PASSWORD MAKE MAX 255 FOR IT TO HASH //
 
 @NotEmpty(message="Password is required!")
 @Size(min=3, max=255, message = "Password must be 3 to 30 characters long!")
 private String password;
 
 @Transient
 @NotEmpty(message="Password is required!")
 @Size(min=8, max=255, message="Password does not match!")
 private String confirm;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 //Using n:m annotation to create relationship without extra entity/columns
 @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
 private List<Product> products;
 

 @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
 private List<Category> categories;
 
 public User() {
     
 }


@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getConfirm() {
	return confirm;
}


public void setConfirm(String confirm) {
	this.confirm = confirm;
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


public List<Product> getProducts() {
	return products;
}


public void setProducts(List<Product> products) {
	this.products = products;
}


public List<Category> getCategories() {
	return categories;
}


public void setCategories(List<Category> categories) {
	this.categories = categories;
}



}

