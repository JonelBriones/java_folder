package com.jonel.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonel.ProjectManager.models.Project;
import com.jonel.ProjectManager.models.User;
import com.jonel.ProjectManager.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired //auto injecting repository
    private ProjectRepository projectRepo;
    // register/create a user from submitting user form
    // TO-DO: Write register and login methods!
    // returns all the books
    public List<Project> all() {
        return projectRepo.findAll();
    }
    
    // creates a book
    public Project create(Project b) {
        return projectRepo.save(b);
    }
   // update a book
    public Project update(Project b) {
        return projectRepo.save(b);
    }
    

    public Project retrieve(Long id) {
    	return projectRepo.findById(id).get();
    }
    // retrieves a book by id
    public Project findId(Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    
//    public void joinProject(Project book, User user) {
//    	List<User> project = book.getBorrows();
//    	borrows.add(user);
//    	projectRepo.save(book);
//    }
//    public void returnBook(Project book, User user) {
//    	List<User> borrows = book.getBorrows();
//    	borrows.remove(user);
//    	projectRepo.save(book);
//    }
    
   // deletes a book
     public void delete(Long id) {
    	 projectRepo.deleteById(id);
     }
	
}
