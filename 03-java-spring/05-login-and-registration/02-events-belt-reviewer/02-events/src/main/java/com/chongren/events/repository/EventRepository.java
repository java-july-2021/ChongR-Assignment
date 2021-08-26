package com.chongren.events.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.events.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	
//	Event findById();
//	
//	List<Event> findAll();
	
//	List<Event> findByUser(User user);
//	
//	List<Event> findByMessage(Message message);
	
	List<Event> findAllByState(String state);
	
	List<Event> findAllByStateIsNot(String state);
}