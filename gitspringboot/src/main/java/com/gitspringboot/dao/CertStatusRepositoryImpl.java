package com.gitspringboot.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gitspringboot.model.CertDetails;

@Repository
public class CertStatusRepositoryImpl implements CertStatusRepositoryCustom {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<CertDetails> retrieveCertDetailsNintyDaysNotNEW(long noOfDays) {
		Date localNintyDate = Date.from(LocalDate.now().plusDays(noOfDays).atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("localNintyDate="+localNintyDate);
		List<CertDetails> listCert=entityManager.createQuery(
				"SELECT e from CertDetails e WHERE e.status<>'RENEWED' and e.status<>'ABT_EXP' AND e.expDate BETWEEN ?1 AND ?2")
				.setParameter(1,new Date(), TemporalType.DATE)
				.setParameter(2,localNintyDate, TemporalType.DATE).getResultList();
		
	    return listCert;
	}

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
