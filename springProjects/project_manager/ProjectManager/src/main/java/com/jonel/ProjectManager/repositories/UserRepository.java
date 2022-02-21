package com.jonel.ProjectManager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonel.ProjectManager.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	 Optional<User> findById(Long id);

	    List<User> findAll();

	    User findByEmail(String email);

}
