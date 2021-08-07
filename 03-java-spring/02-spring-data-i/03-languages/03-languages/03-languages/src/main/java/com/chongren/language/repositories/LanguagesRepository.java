package com.chongren.language.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.language.models.Languages;

@Repository
public interface LanguagesRepository extends CrudRepository<Languages,Long>{
	
	// this method retrieves all the languages from the database
	List<Languages>findAll();
	
}
