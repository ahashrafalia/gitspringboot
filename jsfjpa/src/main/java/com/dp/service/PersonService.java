package com.dp.service;

import java.util.List;

import com.db.bean.PersonBean;
import com.dp.entity.Person;

public interface PersonService {
	
		public Person create(PersonBean person);
		public Person update(Person person);
		public void destroy(Person person) throws Exception;
		public Person findById(Long id);
		public List<Person> findAll();
	
}
