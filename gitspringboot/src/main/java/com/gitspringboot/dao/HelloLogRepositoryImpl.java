package com.gitspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.gitspringboot.model.HelloLog;

public class HelloLogRepositoryImpl implements HelloLogRepositoryCustom {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public List<HelloLog> findByAVeryComplicatedQuery(Long id, String name) {
		
		 Criteria crit = entityManager.unwrap(Session.class).createCriteria(HelloLog.class);
         crit.add(Restrictions.eq("name", name));
         crit.add(Restrictions.eq("uid", Integer.valueOf(id.intValue())));
         List<HelloLog> helloLogList = crit.list();
         
         return helloLogList;
	}

}
