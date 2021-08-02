package com.chongren.language.controllers;

import java.awt.print.Book;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<Languages> languages = langServ.allLang();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Languages lang = langService.findLang(id);
        model.addAttribute("languages", lang);
        return "/languages/edit.jsp";
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("languages") Languages lang, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            langService.updateLang(lang);
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	langServ.deleteLang(id);
        return "redirect:/languages";
    }

}
