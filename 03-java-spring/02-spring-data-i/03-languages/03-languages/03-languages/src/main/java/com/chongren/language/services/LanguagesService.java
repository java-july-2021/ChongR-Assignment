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
	
	public Languages findALang(Long id) {
		return this.langRepo.findById(id).orElse(null);
	}
	
	
	//Create 
	public Languages createBook(Languages newlang){
		return this.langRepo.save(newlang);
	}
		
	
	//Update a Language
//	public Languages updateLang(Long id, String name, String creator, String version) {
//		return langRepo.save(ulang);
//	}
	
	public Languages updateLang(Languages ulang) {
		return this.langRepo.save(ulang);
	}
	
	
	//Delete a Language
	public void deleteLang(Long id) {
		this.langRepo.deleteById(id);
	}
	
	
}
