package com.example.crudtest.service;

import com.example.crudtest.model.Person;

public interface PersonService {
	Iterable<Person> findAll();
	
	Person save(String firstname, String lastname, String occupation);
	
	void deleteById(Person person);
	
	Iterable<Person> find(String firstname, String lastname);
}
