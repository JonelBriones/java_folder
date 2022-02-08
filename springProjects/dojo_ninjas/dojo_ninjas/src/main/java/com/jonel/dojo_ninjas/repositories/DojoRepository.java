package com.jonel.dojo_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonel.dojo_ninjas.models.Dojo;	// ...
@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	    // this method retrieves all the books from the database
	    List<Dojo> findAll();
//	    // this method finds books with descriptions containing the search string
//	    List<(table name)> findByDescriptionContaining(String search);
//	    // this method countsDojoRepository.java how many titles contain a certain string
//	    Long countByTitleContaining(String search);
//	    // this method deletes a book that starts with a specific title
//	    Long deleteByTitleStartingWith(String search);
}
