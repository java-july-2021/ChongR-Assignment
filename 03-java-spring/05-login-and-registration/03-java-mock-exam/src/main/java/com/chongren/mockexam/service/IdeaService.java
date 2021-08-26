package com.chongren.mockexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.mockexam.model.Idea;
import com.chongren.mockexam.model.User;
import com.chongren.mockexam.repository.IdeaRepositpory;



@Service
public class IdeaService {
	@Autowired
	public IdeaRepositpory iRepo;
	
	public List<Idea> getAllIdeas(){
		return this.iRepo.findAll();
	}
	
	
	public Idea getOneIdea(Long Id) {
		return this.iRepo.findById(Id).orElse(null);
	}
	
	public Idea create(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public void likeIdea(Idea idea, User user) {
		List<User> likers = idea.getLikers();
		likers.add(user);
		this.iRepo.save(idea);
	}
}
