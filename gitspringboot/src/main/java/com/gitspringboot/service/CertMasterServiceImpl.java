package com.gitspringboot.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gitspringboot.config.SchedulerProperties;
import com.gitspringboot.dao.CertMasterRepository;
import com.gitspringboot.logger.Loggable;
import com.gitspringboot.model.CertMaster;

@Service
public class CertMasterServiceImpl implements CertMasterService,Loggable {

	@Autowired
	CertMasterRepository certMasterRepository ; 
	
	@Autowired
	SchedulerProperties schedulerProperties;
	
	@Override
	public CertMaster save(CertMaster entity) {
		// TODO Auto-generated method stub
		return certMasterRepository.save(entity);
		
	}

	@Override
	public CertMaster getById(Serializable id) {
		return certMasterRepository.getOne((Long) id);
	}

	@Override
	public List<CertMaster> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Serializable id) {
		certMasterRepository.delete((Long)id);
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
		 logger().info("from funcation interface logger getAllCertViaProcedure");
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

	@Override
	public Page<CertMaster> getAllCertPagable(Pageable pagable) {
		// TODO Auto-generated method stub
		return certMasterRepository.findAll(pagable);
	}

}
