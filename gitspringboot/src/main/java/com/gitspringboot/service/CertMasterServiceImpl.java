package com.gitspringboot.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gitspringboot.dao.CertMasterRepository;
import com.gitspringboot.model.CertMaster;

@Service
public class CertMasterServiceImpl implements CertMasterService {

	@Autowired
	CertMasterRepository certMasterRepository ; 
	
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

}
