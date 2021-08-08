package com.chongren.license.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.license.model.License;
import com.chongren.license.model.Person;
import com.chongren.license.repository.LicenseRepository;
import com.chongren.license.repository.PersonRepository;

@Service
public class DMVService {
	@Autowired
	private LicenseRepository lRepo;
	@Autowired
	private PersonRepository pRepo;
	
//	private final LicenseRepository lRepo;
//	private final PersonRepository pRepo;
//	public DMVService(LicenseRepository lRepo, PersonRepository pRepo) {
//		this.lRepo = lRepo;
//		this.pRepo = pRepo;
//	}
	
	
	//Create new person
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	//Get person id
	public Person getOnePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//Find all person
	public List<Person> getAllPeople(){
		return this.pRepo.findAll();
	}
	
	//Get unlicensed ppl
	public List<Person> getUnlicensedPeople(){
		return this.pRepo.findByLicenseIsNull();
	}
	
	//Generate new license number
	public int generateLicenseNumber() {
		License l = this.lRepo.findTopByOrderByNumberDesc();
		if(l == null) {
			return 1;
		}
		int previousLicenseNumber = l.getNumber();
		previousLicenseNumber++;
		return (previousLicenseNumber);
		
	}
	
	//Create new license
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return this.lRepo.save(license);
	}
	
	

}
