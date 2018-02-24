package com.dp.controller;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.db.bean.PersonBean;
import com.dp.dao.PersonDao;
import com.dp.entity.Person;
import com.dp.service.PersonService;

 


@ManagedBean
public class PersonController extends SpringBeanAutowiringSupport{
	
 
	
	@Autowired
	PersonService personService;
	
	private PersonBean personBean = new PersonBean();
	
	
   
    
    public void welcome(){
    	System.out.println("hi personDao="+personBean.getName()+" "+personService.create(new Person()));
    }




	public PersonBean getPersonBean() {
		return personBean;
	}




	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	
 
}