package com.chongren.language.controllers;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chongren.language.models.Languages;
import com.chongren.language.services.LanguagesService;

public class LanguagesController {
	private final LanguagesService langService;
	
	public LanguagesController(LanguagesService langServ) {
		this.langService = langServ;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
//		List<Languages> languages = langServ.allLang();
		model.addAttribute("languages", langService.allLang());
		return "index.jsp";
	}
	
//	@RequestMapping("/languages/{id}/edit")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Languages lang = langService.findLang(id);
//        model.addAttribute("languages", lang);
//        return "/languages/edit.jsp";
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("languages") Languages lang, BindingResult result, Model model) {
        if (result.hasErrors()) { 
        	model.addAttribute("allLang", this.langService.allLang());
            return "/languages/edit.jsp";
        } else {
            langService.updateLang(lang);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	langService.deleteLang(id);
        return "redirect:/languages";
    }
    
    @GetMapping("/show/{id}")
    public String showLang(Model model, @PathVariable("id")Long id) {
    	model.addAttribute("thisLang", this.langService.findLang(id));
    	return "show.jsp";
    } 
     
    @GetMapping("/edit/{id}")
    public String editLang(Model model, @PathVariable("id")Long id) {
    	model.addAttribute("language", this.langService.findLang(id));
    	return "edit.jsp";
    }
    
    
    @PutMapping("/edit/{id}")
    public String editLang(@Valid @ModelAttribute("language")Languages lang, BindingResult result, Model model, @PathVariable("id")Long id) {
    	if(result.hasErrors()) {
    		model.addAttribute("thisLang", this.langService.findLang(id));
    		return "edit.jsp";
    	}
    	this.langService.updateLang(lang);
    	return "redirect:/show/{id}";
    }  
    

}
