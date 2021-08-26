package com.chongren.events.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="messages")
public class Message {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	private String message_body;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	//========================= M2M ============================//
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
   
	private User user;
	
	//========================= M2M ============================//
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    
    private Event event;
		
		
	//========================= Constructor ============================//
	
	public Message() {
	
	}
	
	

	public Message(User user, Event event, @NotBlank String message_body) {
		this.message_body = message_body;
		this.user = user;
		this.event = event;
	}



	//========================= Getters & Setters ============================//
	
	@PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getMessage_body() {
		return message_body;
	}



	public void setMessage_body(String message_body) {
		this.message_body = message_body;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Event getEvent() {
		return event;
	}



	public void setEvent(Event event) {
		this.event = event;
	}

	
	

}
