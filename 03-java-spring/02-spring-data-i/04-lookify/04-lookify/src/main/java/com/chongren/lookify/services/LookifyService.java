package com.chongren.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chongren.lookify.models.Lookify;
import com.chongren.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private LookifyRepository  LRepo;
	
	public LookifyService(LookifyRepository LRepo) {
		this.LRepo = LRepo;
	}
	
	public List<Lookify> getAll(){
		return LRepo.findAll();
	}
	
	
	//Retrieve a song
	public Lookify findASong(Long id) {
		return this.LRepo.findById(id).orElse(null);
	}
	
	//Create a song
	public Lookify addASong(Lookify newsong) {
		return this.LRepo.save(newsong);
	}
	
	//Delete a song
	public void deleteASong(Long id) {
		this.LRepo.deleteById(id);
	}
	
	//Update a song
		public Lookify updateASong(Lookify usong) {
			return this.LRepo.save(usong);
		}
		
	
}
