package com.gitspringboot.service;

import java.util.List;

import com.gitspringboot.model.CertDetails;

public interface CertStatusService extends ICRUDService<CertDetails> {

	public List<CertDetails> saveBatchUpdate(List<CertDetails> entities) ;
	public List<CertDetails> retrieveCertDetailsNintyDays() ;
		
}
