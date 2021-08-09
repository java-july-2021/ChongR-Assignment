package com.chongren.dojoninja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.dojoninja.model.Dojo;
import com.chongren.dojoninja.model.Ninja;
import com.chongren.dojoninja.repository.DojoRepository;
import com.chongren.dojoninja.repository.NinjaRepository;

@Service
public class MasterService {
	
	@Autowired
	DojoRepository dRepo;
	
	@Autowired
	NinjaRepository nRepo;
	
	
	//Show all Ninjas
	public List<Ninja> showAll() {
		return this.nRepo.findAll();
	}
	
	
	//Create a Ninja
	public Ninja createNinja(Ninja newNinja) {
		return this.nRepo.save(newNinja);
	}
	
	//Find a Ninja by id
	public Ninja getNinja(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	
	
	//Show all Dojos
	public List<Dojo> allDojo(){
		return this.dRepo.findAll();
	}
	
	
	//Create a Dojo
	public Dojo createDojo(Dojo newDojo) {
		return this.dRepo.save(newDojo);
	}
	
	
	//Find a Dojo by id
	public Dojo getDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	


}
