package com.chongren.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chongren.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository <Lookify, Long> {
	List<Lookify>findAll();
}
