package com.example.crudtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crudtest.service.PersonServiceImpl;

@Controller
public class CrudController {
	@Autowired
	private PersonServiceImpl personService;
	
	@RequestMapping(name="/", method = RequestMethod.GET)
	public String index(@RequestParam(name = "firstname", required = false, defaultValue = "") String firstname, 
			@RequestParam(name = "lastname", required = false, defaultValue = "") String lastname, Model model) {
		model.addAttribute("person", personService.find(firstname, lastname));
		model.addAttribute("added", "");
		return "index";
	}
	
	@RequestMapping(name="/", method = RequestMethod.POST)
	public String index(@RequestParam(name = "firstname", required = false, defaultValue = "") String firstname, 
			@RequestParam(name = "lastname", required = false, defaultValue = "") String lastname, 
			@RequestParam(name = "occupation", required = false, defaultValue = "") String occupation, Model model) {
		model.addAttribute("added", personService.save(firstname, lastname, occupation));
		return "index";
	}
}
