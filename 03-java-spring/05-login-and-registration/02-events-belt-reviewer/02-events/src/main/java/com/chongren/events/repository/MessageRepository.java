package com.chongren.events.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.events.model.Message;


@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	
//	Message findById();
//	
//	List<Message> findAll();
//	
//	List<Message> findByEmail(Event event);
//	
//	List<Message> findByUser(User user);
}
