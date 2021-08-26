package com.chongren.DojoOverflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.DojoOverflow.model.Question;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	
	List<Question> findAll();


}
