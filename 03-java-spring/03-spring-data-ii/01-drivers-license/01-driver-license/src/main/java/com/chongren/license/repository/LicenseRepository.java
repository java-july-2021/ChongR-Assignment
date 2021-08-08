package com.chongren.license.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.license.model.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
}
