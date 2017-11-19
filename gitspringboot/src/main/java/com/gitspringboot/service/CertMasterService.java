package com.gitspringboot.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.gitspringboot.model.CertMaster;

public interface CertMasterService extends ICRUDService<CertMaster> {

	public List<CertMaster> withDate(Specification<CertMaster> spec);
	
	
	List<CertMaster>  searchCertViaProcedure(String s1, String d1, String d2);
	List<CertMaster>  getAllCertViaProcedure();
}
