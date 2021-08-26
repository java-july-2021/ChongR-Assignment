package com.chongren.mockexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chongren.mockexam.model.Idea;

@Repository
public interface IdeaRepositpory extends CrudRepository<Idea, Long>{

	List<Idea> findAll();
}
