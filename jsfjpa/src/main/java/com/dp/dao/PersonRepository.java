package com.dp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>,PersonRepositoryCustom{

	/*public Person create(Person person);
	public Person update(Person person);
	public void destroy(Person person) throws Exception;
	public Person findById(Long id);
	public List<Person> findAll();*/
}
