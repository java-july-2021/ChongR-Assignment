package com.chongren.DojoOverflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.DojoOverflow.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	
	Tag findBySubject (String subject);
	
	boolean existsBySubject(String subject);
	
	List<Tag> findAll();
	
//	List<Tag> findQuestionsNotContains(Question question);
}
