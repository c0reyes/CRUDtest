package com.example.crudtest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crudtest.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	Iterable<Person> findByFirstnameContainsIgnoreCaseAndLastnameContainsIgnoreCase(String firstname, String lastname);
}
