package com.gitspringboot.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gitspringboot.config.SchedulerProperties;
import com.gitspringboot.dao.CertMasterRepository;
import com.gitspringboot.model.CertMaster;

@Service
public class CertMasterServiceImpl implements CertMasterService {

	@Autowired
	CertMasterRepository certMasterRepository ; 
	
	@Autowired
	SchedulerProperties schedulerProperties;
	
	@Override
	public CertMaster save(CertMaster entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CertMaster getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CertMaster> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CertMaster> withDate(Specification<CertMaster> spec) {
		return certMasterRepository.findAll(spec);
		//return null;
	}
	
	

	@Override
	public List<CertMaster> searchCertViaProcedure(String s1, String d1, String d2) {
		return certMasterRepository.searchCertViaProcedure(s1, d1, d2);
	}

	@Override
	public List<CertMaster> getAllCertViaProcedure() {
		return certMasterRepository.getAllCertViaProcedure();
	}

	@Override
	public List<CertMaster> getCertCountClient() {
		Date localNintyDate = Date.from(LocalDate.now().plusDays(schedulerProperties.getNintyDays()).atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("From Date="+new Date()+", TO Date="+localNintyDate);
		List<CertMaster> list90= certMasterRepository.certCountClientBy90(new Date(), localNintyDate);
		System.out.println("List90 size="+list90.size());
		return list90;
	}

}
