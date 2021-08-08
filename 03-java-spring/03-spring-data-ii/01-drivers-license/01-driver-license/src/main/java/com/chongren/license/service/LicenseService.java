package com.chongren.license.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.license.model.License;
import com.chongren.license.repository.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lRepo;
	
	
	public License createLicense(License license) {
		return this.lRepo.save(license);
	}
}
