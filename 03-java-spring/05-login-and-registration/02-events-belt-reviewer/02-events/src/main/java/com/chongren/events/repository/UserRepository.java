package com.chongren.events.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.events.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
//	User findById();
	
	User findByState(String state);
	
	List<User> findAll();
	
	boolean existsByEmail(String email);
	
	User findByEmail(String email);
	
//	List<User> findByEvent(Event event);
	
//	List<User> findByMessage(Message message);
}
