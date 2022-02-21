package com.jonel.ProjectManager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonel.ProjectManager.models.Project;
import com.jonel.ProjectManager.models.User;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	    List<Project> findAll();

}
