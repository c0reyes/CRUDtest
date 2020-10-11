package com.example.crudtest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crudtest.model.Person;
import com.example.crudtest.service.PersonServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setOccupation(occupation);

		personService.save(person);
		
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("classname","alert-success"); // alert-danger
		msg.put("text","Person saved");
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@GetMapping("/delete")
	public String detele(@RequestParam(name = "id", required = false, defaultValue = "") long id, Model model) {
		Person person = new Person();
		person.setId(id);

		personService.deleteById(person);
		
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("classname","alert-success"); // alert-danger
		msg.put("text","Person deleted");
		model.addAttribute("msg", msg);
		
		return "index";
	}
}
