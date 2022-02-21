package com.jonel.ProjectManager.models;



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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


//..
@Entity
@Table(name="projects")
public class Project {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Size(min=3, max=30, message = "Title must be 3 to 30 characters long!")
 private String title;

 @Size(min=3, max=255, message = "Description must be 3 to 255 characters long!")
 private String description;
 
 @NotEmpty(message="Due date is required!")
 private String date;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 //Using n:m annotation to create relationship without extra entity/columns
 @ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="user_id")
 private User user;
 
 @ManyToMany(fetch=FetchType.LAZY)
 @JoinTable(
		 name="team",
		 joinColumns=@JoinColumn(name = "project_id"),
		 inverseJoinColumns = @JoinColumn(name = "user_id"))
 private List<User> team;
 
 public Project() {
     
 }

 

public List<User> getTeam() {
	return team;
}



public void setTeam(List<User> team) {
	this.team = team;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public String getDate() {
	return date;
}



public void setDate(String date) {
	this.date = date;
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
