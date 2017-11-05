package com.gitspringboot.dao;

import java.util.Date;
import java.util.List;

import com.gitspringboot.model.CertDetails;


public interface NotifyRepositoryCustom {
	List<CertDetails> retrieveCertDetailsNintyDays(long noOfDays);
}
