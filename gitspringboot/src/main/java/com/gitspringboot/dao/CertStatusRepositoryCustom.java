package com.gitspringboot.dao;

import java.util.List;

import com.gitspringboot.model.CertDetails;

public interface CertStatusRepositoryCustom {

	List<CertDetails> retrieveCertDetailsNintyDaysNotNEW(long noOfDays);
	List<CertDetails> retrieveCertDetailsNintyDays(long noOfDays);
}
