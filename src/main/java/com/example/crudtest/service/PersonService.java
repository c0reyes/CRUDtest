package com.example.crudtest.service;

import com.example.crudtest.entity.Person;

public interface PersonService {
	Iterable<Person> findAll();
	
	Person save(Person person);
	
	void deleteById(Person person);
	
	Iterable<Person> find(String firstname, String lastname);
}
