package com.chongren.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chongren.language.models.Languages;
import com.chongren.language.repositories.LanguagesRepository;

@Service
public class LanguagesService {
	private final LanguagesRepository langRepo;
	
	public LanguagesService(LanguagesRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	//Return all
	public List<Languages> allLang(){
		return langRepo.findAll();
	}
	
	//Create 
	public Languages createBook(Languages l){
		return langRepo.save(l);
	}
	
	//Retrieves a book
	public Languages findLang(Long id) {
		Optional<Languages> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		}
		else {
			return null;
		}
	}
	
	//Update a Language
	public Languages updateLang(Long id, String name, String creator, String version) {
		return null;
	}
	
	public Languages updateLang(Languages lang) {
		return null;
	}
	
	
	//Delete a Language
	public void deleteLang(Long id) {
		langRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
