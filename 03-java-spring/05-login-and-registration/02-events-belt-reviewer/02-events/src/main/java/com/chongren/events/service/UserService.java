package com.chongren.events.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.events.model.User;
import com.chongren.events.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public List<User> getAllUsers(){
		return this.uRepo.findAll();
	}
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public User registerUser(User user) {
		//1. Generate a hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		//2. Set the hash pw on the user pw field
		user.setPassword(hash);
		
		//3. Save the new user pw to the database
		return this.uRepo.save(user);
	} 
	
	public boolean authenicateUser(String email, String password) {
		//Make sure the user logging in is who they claim they are
		//Query for the user by email
		User user = this.uRepo.findByEmail(email);
		
		//Check provided email against email in the database
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User geyByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
//	public String getState(Long id){
//		this.uRepo.findByState()
//	}

}
