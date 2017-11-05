package com.gitspringboot.service;

import java.util.Date;
import java.util.List;

import com.gitspringboot.model.CertDetails;

public interface NotifyService extends ICRUDService<CertDetails> {
	List<CertDetails> retrieveCertDetailsNintyDays(long noOfDays);
}
