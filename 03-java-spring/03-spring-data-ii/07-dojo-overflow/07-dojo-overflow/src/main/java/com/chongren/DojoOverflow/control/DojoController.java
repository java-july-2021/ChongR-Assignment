package com.chongren.DojoOverflow.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chongren.DojoOverflow.model.Answer;
import com.chongren.DojoOverflow.model.Question;
import com.chongren.DojoOverflow.service.DojoService;
import com.chongren.DojoOverflow.validator.DojoValidator;

@Controller
public class DojoController {
	@Autowired
	private DojoService dServ;
	
	@Autowired
	private DojoValidator validator;
	
	//------------------------- Home Page -----------------------//
		@RequestMapping("/")
		public String index(Model viewModel) {
			List<Question> allQuestion = this.dServ.showAllQuestion();
			viewModel.addAttribute("allQuestion", allQuestion);
			return "dashboard.jsp";
		}
		
	//------------------------- New Question Page -----------------------//
		@GetMapping("/questions/new")
		public String newQuestion(@ModelAttribute("question") Question question) {
			return "NewQuestion.jsp";
		}
		
		@PostMapping("/newquestion")
		public String processNewQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
			//Valid, if tag exsit, add to question; if not, create tag first then add to question. Each question can have max 3 tags
		
			validator.validate(question, result);
			if(result.hasErrors()) {
				return "NewQuestion.jsp";
			}
//			this.dServ.createQuestion(question);
			this.dServ.createQuestionFromFrontEnd(question);
			System.out.println(question);
			return "redirect:/";
		}
		
		
	//------------------------- New Answer Page -----------------------//
		@GetMapping("/questions/{id}")
		public String newQuestion(@ModelAttribute("answer") Answer answer, @PathVariable("id")Long id, Model viewModel) {
			viewModel.addAttribute("question", this.dServ.findSingleQuestion(id));
			return "NewAnswer.jsp";
		}
		
		@PostMapping("/newanswer/{id}")
		public String processNewQuestion(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, @PathVariable("id")Long qid, Model viewModel) {
			
			if(result.hasErrors()) {
				viewModel.addAttribute("question", this.dServ.findSingleQuestion(qid));
				return "NewAnswer.jsp";
			}
			Question thisQ = this.dServ.findSingleQuestion(qid);
			this.dServ.addAnswerToQuestion(answer, thisQ);
//			this.dServ.createAnswer(answer);
			return "redirect:/questions/" + answer.getQuestion().getId();
			
		}
		
		
//		@PostMapping("/newanswer")
//		public String processNewQuestion(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model viewModel) {
//			
//			if(result.hasErrors()) {
//				viewModel.addAttribute("question", this.dServ.findSingleQuestion(answer.getQuestion().getId()));
//				return "NewAnswer.jsp";
//			}
//			this.dServ.createAnswer(answer);		
//			return "redirect:/";
//			
//		}
}
