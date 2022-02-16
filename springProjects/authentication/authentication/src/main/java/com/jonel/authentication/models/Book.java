package com.jonel.authentication.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity //names//
@Table(name="books")
public class Book {
// constraints
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 40)
    private String title;
    @NotNull
    @Size(min = 2, max = 40)
    private String author;
    @NotNull
    @Size(min = 2, max = 100)
    private String thought;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToMany(fetch=FetchType.LAZY)
    	@JoinTable(
    		name="borrows",
    		joinColumns=@JoinColumn(name = "book_id"),
    		inverseJoinColumns = @JoinColumn(name= "user_id"))
    private List<User> borrows;
    
    
    
    public List<User> getBorrows() {
		return borrows;
	}
    
    
    
	public void setBorrows(List<User> borrows) {
		this.borrows = borrows;
	}




	public Book() {
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




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public String getThought() {
		return thought;
	}




	public void setThought(String thought) {
		this.thought = thought;
	}


	




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}


	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}