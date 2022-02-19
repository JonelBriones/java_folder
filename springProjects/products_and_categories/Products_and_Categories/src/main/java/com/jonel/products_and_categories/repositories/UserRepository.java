package com.jonel.products_and_categories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonel.products_and_categories.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	// Retrieves a list of all categories for a particular product
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    Optional<User> findById(Long id);

    List<User> findAll();

    User findByEmail(String email);

    
}
