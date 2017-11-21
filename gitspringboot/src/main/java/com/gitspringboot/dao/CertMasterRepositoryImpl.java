package com.gitspringboot.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.gitspringboot.model.CertMaster;

public class CertMasterRepositoryImpl implements CertMasterRepositoryCustom {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public List<CertMaster> searchCertViaProcedure(String s1, String d1, String d2) {
		//List<CertMaster> listCert = (List<CertMaster>) this.entityManager.
		//		createNamedStoredProcedureQuery("GetCertDetails").getResultList();
		StoredProcedureQuery q =this.entityManager.createNamedStoredProcedureQuery("GetCertDetails");
		q.setParameter(1, s1);
		q.setParameter(2, d1);
		q.setParameter(3, d2);
		List<CertMaster> listCert = (List<CertMaster>)q.getResultList();
		return listCert;
	}

	@Override
	public List<CertMaster> getAllCertViaProcedure() {
		StoredProcedureQuery q =this.entityManager.createNamedStoredProcedureQuery("GetAllCertDetails");
		List<CertMaster> listCert = q.getResultList();
		return listCert;
	}

	/*@Override
	public List<CertMaster> getCertCountClient(Date d1, Date d2) {
		
		return null;
	}*/

}
