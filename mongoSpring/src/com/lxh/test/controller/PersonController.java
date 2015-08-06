package com.lxh.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxh.test.entity.Person;
import com.lxh.test.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private static Log log = LogFactory.getLog(PersonController.class.getName());  
	
	@Resource
	private PersonService perosonService;
	
	@RequestMapping("/insert")
	public void insert(){
		Person p=new Person("cuiran",27); 
		perosonService.insert(p);
		log.debug("Ìí¼Ó³É¹¦"); 
	}
	
	@RequestMapping("/getAll")
	public void getAll(){
		List<Person> personList=perosonService.findAll();
		if(personList!=null&&personList.size()>0){
			for(Person person:personList){
				System.out.println("name:"+person.getName()+",age:"+person.getAge());
			}
		}
	}
	
	@RequestMapping("/insertDocument")
	public void insertDocument(){
		
	}

}
