package com.chongren.license.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="persons")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@NotNull
	private String firstName;
	@NotBlank
	@NotNull
	private String lastName;
	@Column(updatable=false)
	private Date createAt;
	private Date updateAt;
	
	@OneToOne(mappedBy="persons", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private String license;

///////////////////////////////////////////////////////////////////////////    
	
	public Person() {
		
	}


	public Person(@NotBlank @NotNull String firstName, @NotBlank @NotNull String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

///////////////////////////////////////////////////////////////////////////    

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


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public Date getUpdateAt() {
		return updateAt;
	}


	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}


	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}
	
	
	
	
	
}
