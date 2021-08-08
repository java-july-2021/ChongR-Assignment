package com.chongren.license.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.license.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
//	List<Person> findByNoLicense();
	List<Person> findByLicenseIsNull();
	
}
