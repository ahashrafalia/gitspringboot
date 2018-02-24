package com.dp.service;

import java.util.List;

import com.dp.entity.Person;

public interface PersonService {
	
		public Person create(Person person);
		public Person update(Person person);
		public void destroy(Person person) throws Exception;
		public Person findById(Long id);
		public List<Person> findAll();
	
}
