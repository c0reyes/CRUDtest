package com.example.crudtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(length = 20)
	private String firstname;
	
	@Column(length = 20)
	private String lastname;
	
	@Column(length = 50)
	private String occupation;
	
	public Person() {}
	
	public Person(long id) {
		this.id = id;
	}
	
	public Person(String firstname, String lastname, String occupation) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.occupation = occupation;
	}
	
	public Person(long id, String firstname, String lastname, String occupation) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.occupation = occupation;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
}
