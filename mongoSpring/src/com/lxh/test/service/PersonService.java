package com.lxh.test.service;

import java.util.List;

import com.lxh.test.entity.Person;

public interface PersonService {

	public void insert(Person person);
	
	public Person findOne(String id);
	
	public List<Person> findAll();
	
	public List<Person> findByRegex(String regex);
	
	public void removeOne(String id); 
	
	public void removeAll(); 
	
	public void findAndModify(String id);
}
