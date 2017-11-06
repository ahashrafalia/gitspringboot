package com.gitspringboot.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.gitspringboot.model.CertDetails;


public class NotifyRepositoryImpl implements NotifyRepositoryCustom {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public List<CertDetails> retrieveCertDetailsNintyDays(long noOfDays) {
		
		Date localNintyDate = Date.from(LocalDate.now().plusDays(noOfDays).atStartOfDay(ZoneId.systemDefault()).toInstant());
		List<CertDetails> listCert=entityManager.createQuery(
				"SELECT e from CertDetails e WHERE e.expDate BETWEEN ?1 AND ?2")
				.setParameter(1,new Date(), TemporalType.DATE)
				.setParameter(2,localNintyDate, TemporalType.DATE).getResultList();
		
	    return listCert;
	}

}
