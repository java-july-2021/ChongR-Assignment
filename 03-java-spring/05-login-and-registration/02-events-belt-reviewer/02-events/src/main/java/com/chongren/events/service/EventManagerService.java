package com.chongren.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.events.model.Event;
import com.chongren.events.model.Message;
import com.chongren.events.model.User;
import com.chongren.events.repository.EventRepository;
import com.chongren.events.repository.MessageRepository;
import com.chongren.events.repository.UserRepository;

@Service
public class EventManagerService {
	@Autowired 
	public UserRepository uRepo;
	
	@Autowired
	public EventRepository eRepo;
	
	@Autowired
	public MessageRepository mRepo;
	
	
	//========================== Event ==============================//
	
	//Create
	public Event createEvent(Event newEvent) {
		return this.eRepo.save(newEvent);
	}
	
	//Read
	public Event findAEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	//Update
	public Event updateEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	//Delete
	public void deleteEvent(Long id) {
		this.eRepo.deleteById(id);
	}
	
	//Show All
//	public List<Event> showAllEvent(){
//		return this.eRepo.findAll();
//	}
	
	//Show Events in Same State
	public List<Event> showSameStateEvent(String state){
		return this.eRepo.findAllByState(state);
	}
	
	//Show Events in Other State
	public List<Event> showOtherStateEvent(String state){
		return this.eRepo.findAllByStateIsNot(state);
	}
	
	//ManageAttendees
	public void manageAttendees(Event event, User user, boolean isjoinging) {
		if(isjoinging) {
			event.getUsers().add(user);
			
		}
		else {
			event.getUsers().remove(user);
		}
		this.eRepo.save(event);
	}
	
	
	//========================== Message ==============================//
	
//	
//	//Create
//	public Message createMessge(Message message) {
//		return this.mRepo.save(message);
//	}
//	
//	//Read
//	public Message findAMessage(Long id) {
//		return this.mRepo.findById(id).orElse(null);
//	}
//	
//	//Update
//	public Message updateMessage(Message message) {
//		return this.mRepo.save(message);
//	}
//	
//	//Delete
//	public void deleteMessage(Long id) {
//		this.mRepo.deleteById(id);
//	}
//	
//	//Show All
//	public List<Message> showAllMessage(){
//		return this.mRepo.findAll();
//	}
//	
	
	public void comment(User user, Event event, String message_body) {
		this.mRepo.save(new Message(user, event, message_body));
	}
	
	
	
	
	
	
}
