package com.example.crudtest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crudtest.entity.Person;
import com.example.crudtest.service.PersonServiceImpl;

@Controller
@RequestMapping("/")
public class CrudController {
	@Autowired
	private PersonServiceImpl personService;
	
	@GetMapping("/")
	public String index(@RequestParam(name = "firstname", required = false, defaultValue = "") String firstname, 
			@RequestParam(name = "lastname", required = false, defaultValue = "") String lastname, Model model) {
		model.addAttribute("person", personService.find(firstname, lastname));
		return "index";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam(name = "firstname", required = false, defaultValue = "") String firstname, 
			@RequestParam(name = "lastname", required = false, defaultValue = "") String lastname,
			@RequestParam(name = "occupation", required = false, defaultValue = "") String occupation, Model model) {
		personService.save(new Person(firstname, lastname, occupation));
		
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("classname","alert-success"); 
		msg.put("text","Person saved");
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@GetMapping("/delete")
	public String detele(@RequestParam(name = "id", required = false, defaultValue = "") long id, Model model) {
		Map<String, String> msg = new HashMap<String, String>();
		try {
			personService.deleteById(new Person(id));
			
			msg.put("classname","alert-success"); 
			msg.put("text","Person deleted");
			model.addAttribute("msg", msg);
		}catch(Exception exc) {
			msg.put("classname","alert-danger"); 
			msg.put("text","Person not deleted, exception: " + exc.toString());
			model.addAttribute("msg", msg);
		}
		return "index";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam(name = "firstname", required = false, defaultValue = "") String firstname, 
			@RequestParam(name = "lastname", required = false, defaultValue = "") String lastname,
			@RequestParam(name = "occupation", required = false, defaultValue = "") String occupation,
			@RequestParam(name = "id", required = false, defaultValue = "0") long id, Model model) {
		personService.save(new Person(id, firstname, lastname, occupation));
		
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("classname","alert-success"); 
		msg.put("text","Person updated");
		model.addAttribute("msg", msg);
		
		return "index";
	}
}
