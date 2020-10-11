package com.example.crudtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudtest.model.Person;
import com.example.crudtest.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person save(String firstname, String lastname, String occupation) {
		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setOccupation(occupation);
		return personRepository.save(person);
	}

	@Override
	public void deleteById(Person person) {
		personRepository.deleteById(person.getId());
	}

	@Override
	public Iterable<Person> find(String firstname, String lastname) {
		if("".equals(firstname) && "".equals(lastname)) return null;
		return personRepository.findByFirstnameContainsIgnoreCaseAndLastnameContainsIgnoreCase(firstname, lastname);
	}

}
