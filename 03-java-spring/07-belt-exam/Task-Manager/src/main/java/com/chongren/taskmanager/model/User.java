package com.chongren.taskmanager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank
	@Size(max=15)
	private String firstName;
	@Size(max=30)
	private String lastName;
	@Email
	private String email;
	@Size(min=8, message="Password min length is 8chr")
	private String password;
	@Transient
	private String confirmPassword;
	
	
	//============ Constructor ============//
	
	public User() {

	}
	
	//============= 12M ===============//
	@OneToMany(mappedBy="creator", cascade=CascadeType.ALL, fetch=FetchType.LAZY)  //mappedBy the variable in User user<-  in the Idea side
	private List<Task> tasks;
	
	
	//============= 12M ===============//
	@OneToMany(mappedBy="assigned", cascade=CascadeType.ALL, fetch=FetchType.LAZY)  //mappedBy the variable in User user<-  in the Idea side
	private List<Task> assignedTask;
	
	
	//============ Getter & Setter ============//

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	
}
