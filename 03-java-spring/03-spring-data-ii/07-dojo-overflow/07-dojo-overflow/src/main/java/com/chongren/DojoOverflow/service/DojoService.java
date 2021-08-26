package com.chongren.DojoOverflow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.DojoOverflow.model.Answer;
import com.chongren.DojoOverflow.model.Question;
import com.chongren.DojoOverflow.model.Tag;
import com.chongren.DojoOverflow.repository.AnswerRepository;
import com.chongren.DojoOverflow.repository.QuestionRepository;
import com.chongren.DojoOverflow.repository.TagRepository;

@Service
public class DojoService {
	
	@Autowired
	private AnswerRepository aRepo;
	
	@Autowired
	private TagRepository tRepo;
	
	@Autowired
	private QuestionRepository qRepo;
	
	//Split, check duplicate, save a tag to a question
	public ArrayList<Tag> splitTags(String tags) {
		// I, am, a, ninja
		ArrayList<Tag> tagsForQ = new ArrayList<Tag>();
		String[] tagsToProcess = tags.split(", ");
		for(String s: tagsToProcess) {
			if(this.tRepo.existsBySubject(s)) {
				Tag tagToAdd = this.findSingleTag(s);
				tagsForQ.add(tagToAdd);
			}
			else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tRepo.save(newTag);
				tagsForQ.add(this.findSingleTag(s));
			}
		}
		return tagsForQ;
	}
	
	
	// =================== Answer ====================//
	public Answer createAnswer(Answer newAnswer) {
		return this.aRepo.save(newAnswer);
	}
	
	public Answer findSingleAnswer(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	public List<Answer> showAllAnswer(){
		return this.aRepo.findAll();
	}
	 
	// =================== Tag ====================//
	public Tag createTag(Tag newTag) {
		return this.tRepo.save(newTag);
	}
	
	public Tag findATag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	public Tag findSingleTag(String subject) {
		return this.tRepo.findBySubject(subject);
	}
	
	public List<Tag> showAllTag(){
		return this.tRepo.findAll();
	}
	
	// =================== Question ====================//
	public Question createQuestion(Question newQuestion) {
		return this.qRepo.save(newQuestion);
	}
	
	public Question findSingleQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	public List<Question> showAllQuestion(){
		return this.qRepo.findAll();
	}
		
	// ================================== Cross ===================================//
	
	
	// Add Tag to Question
	public void addTagToQuestion(Tag tag, Question question) {
		List<Tag> exsitTag = question.getTags();
		exsitTag.add(tag);
		this.qRepo.save(question);
	}
	
	// Add Answer to Question
		public void addAnswerToQuestion(Answer answer, Question question) {
			List<Answer> exsitAnswer = question.getAnswers();
			exsitAnswer.add(answer);
			this.qRepo.save(question);
		}

	// Add Question to Tag
	public void addQuestionToTag(Tag tag, Question question) {
		List<Question> exsitQuestion = tag.getQuestions();
		exsitQuestion.add(question);
		this.tRepo.save(tag);
	}
	
	
	//////////////////////////////////
	public Question createQuestionFromFrontEnd(Question question) {
		question.setTags(this.splitTags(question.getTagsFromFrontEnd()));
		return this.qRepo.save(question);
	}

}
