package com.chongren.mockexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.mockexam.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findAll();
	
	boolean existsByEmail(String email);
	
	User findByEmail(String email);
	
//	List<Idea> findByOrderByLikesASC();
//	return the idea ordered by likes from most to least
}
