package com.lxh.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxh.test.dao.PersonDao;
import com.lxh.test.entity.Person;
import com.lxh.test.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService{

	@Resource
	private PersonDao personDao;
	
	@Override
	public void insert(Person person) {
		personDao.insert(person);
	}

	@Override
	public Person findOne(String id) {
		return personDao.findOne(id);
	}

	@Override
	public List<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	public List<Person> findByRegex(String regex) {
		return personDao.findByRegex(regex);
	}

	@Override
	public void removeOne(String id) {
		personDao.removeOne(id);
	}

	@Override
	public void removeAll() {
		personDao.removeAll();
	}

	@Override
	public void findAndModify(String id) {
		personDao.findAndModify(id);
	}

}
