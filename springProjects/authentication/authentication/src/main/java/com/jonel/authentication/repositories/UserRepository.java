package com.jonel.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonel.authentication.models.User;

//.. imports .. //

//.. imports .. //

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
 User findByEmail(String email);
 
 
 Optional<User> findById(Long id);
 
}


