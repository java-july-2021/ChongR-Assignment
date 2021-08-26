package com.chongren.DojoOverflow.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.chongren.DojoOverflow.model.Question;


@Component
public class DojoValidator {
//	@Autowired
//	private AnswerRepository aRepo;
//	
//	@Autowired
//	private TagRepository tRepo;
//	
//	@Autowired
//	private QuestionRepository qRepo;
	
	
	
	public boolean supports(Class<?> clazz) {
		return Question.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		
		Question question = (Question) target;
		 String[] tags = question.getTagsFromFrontEnd().split(", ");
		 if(tags.length>3) {
			 errors.rejectValue("tagsFromFrontEnd", "exceed max", "Question can have maximum 3 tags");
		 }
		 
		
//		if(this.qRepo.exsitsByTag(question.getTags())) {
//			errors.rejectValue("tag", "unique", "This tag already exsits.");
//		}	
		
	}
	

}
