package com.chongren.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository <Lookify, Long> {
	List<Lookify>findAll();
	List<Lookify>fingTop10ByOrderByRaingDesc();
	List<Lookify>findByArtistContaining(String artist);
}
