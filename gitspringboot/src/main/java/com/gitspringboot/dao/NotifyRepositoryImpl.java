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
		//Date.from(localNinty.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date localNintyDate = Date.from(LocalDate.now().plusDays(noOfDays).atStartOfDay(ZoneId.systemDefault()).toInstant());
		List<CertDetails> listCert=entityManager.createQuery(
				"SELECT e from CertDetails e WHERE e.expDate BETWEEN ?1 AND ?2")
				.setParameter(1,new Date(), TemporalType.DATE)
				.setParameter(2,localNintyDate, TemporalType.DATE).getResultList();
		 /*CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		   CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		   Root<CertDetails> from = criteriaQuery.from(CertDetails.class);*/
	   /* long today = System.currentTimeMillis();
	    long nDays = days * 24 * 60 * 60 * 1000;
	    long nDaysAgo = today - nDays;
	    Date nDaysAgoDate = new Date( nDaysAgo );

	    // Is here the response to your question?
	    cq.where( cb.lessThanOrEqualTo( root.get(CertDetails_.date), nDaysAgoDate ) );

	    TypedQuery<CertDetails> q = entityManager.createQuery( cq );

	    List<CertDetails> list = q.getResultList();
	    return list;*/
	    return listCert;
	}

}
