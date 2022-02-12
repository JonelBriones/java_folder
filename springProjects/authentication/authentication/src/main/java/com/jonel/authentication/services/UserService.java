package com.jonel.authentication.services;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jonel.authentication.models.LoginUser;
import com.jonel.authentication.models.User;
import com.jonel.authentication.repositories.UserRepository;


@Service
public class UserService {
    
    @Autowired //auto injecting repository
    private UserRepository userRepo;
    // register/create a user from submitting user form
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    // checks if an email is already in the database
    public User findByEmail(String email) {
    	
    	return userRepo.findByEmail(email);
    }
    
    public User findUserById(Long id) {
    	// TWO options to return the id
//    	Optional<User> user = userRepo.findById(id);
//    	
//    	if(user.isPresent()) {
//    		return user.get();
//    	} 
//    	else {
//    		return null;
//    	}
    	return userRepo.findById(id).orElse(null);
    }
    
    public boolean authenticate(String email, String password) {
    	User user = userRepo.findByEmail(email);
    	if(user == null) {
    		return false;
    	}
    	else {
	    	if (BCrypt.checkpw(password, user.getPassword())){
	    		return true;
	    	} else {
	    		return false;
	    	}
    	}
    }
}

