package com.jonel.ProjectManager.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserLogin {
    
    @Email(message="Invalid Email/Password!")
    private String email;
    
    @Size(min=8, max=128, message="Invalid Email/Password!")
    private String password;
    
    public UserLogin() {}

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
    
    // TODO - Don't forget to generate getters and setters
    
}
