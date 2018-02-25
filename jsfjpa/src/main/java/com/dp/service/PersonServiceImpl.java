package com.dp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.db.bean.PersonBean;
import com.dp.dao.PersonRepository;
import com.dp.entity.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Transactional
	public Person create(PersonBean person) {
		System.out.println("personRepository="+personRepository);
		Person p=new Person();
		p.setFirstName(person.getFname());
		p.setLastName(person.getLname());
		p.setEmail(person.getEmail());
		return personRepository.create(p);
	}

	public Person update(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy(Person person) throws Exception {
		// TODO Auto-generated method stub

	}

	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
