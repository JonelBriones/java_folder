package com.jonel.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jonel.products_and_categories.models.LoginUser;
import com.jonel.products_and_categories.models.User;
import com.jonel.products_and_categories.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	
	// find all users
	public List<User> all() {
		return userRepo.findAll();
	}
	
	// register a user
	public User register(User newUser, BindingResult result) {
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
    public User findByEmail(String email) {
    	return userRepo.findByEmail(email);
    }
	
	// find user by id
	public User findId(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	// update user
	public User update(User user) {
		return userRepo.save(user);
	}

	// delete a user by id
	public void delete(Long id) {
		userRepo.deleteById(id);
	}

	// Check Password and name
	public boolean authenticate(String email, String password) {
		User user = userRepo.findByEmail(email);
		// if email exist
		if(user == null)  {
			return false;
			
		} else {
			// if password matches, return true,
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
		
	

}
