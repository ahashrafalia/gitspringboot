package com.dp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dp.entity.Person;

@Repository("personRepository")
public class PersonRepositoryImpl implements PersonRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	public Person create(Person person) {
		System.out.println("em="+em);
		this.em.persist(person);
		return null;
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
