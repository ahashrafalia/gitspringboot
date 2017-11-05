package com.gitspringboot.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitspringboot.dao.NotifyRepository;
import com.gitspringboot.model.CertDetails;

@Service
public class NotifyServiceImpl implements NotifyService {
	
	@Autowired
	NotifyRepository notifyRepository;

	@Override
	public CertDetails save(CertDetails entity) {
		
		return null;
	}

	@Override
	public CertDetails getById(Serializable id) {
		
		return null;
	}

	@Override
	public List<CertDetails> getAll() {
		
		return null;
	}

	@Override
	public void delete(Serializable id) {
		
	}

	@Override
	public List<CertDetails> retrieveCertDetailsNintyDays(long noOfDays) {
		return notifyRepository.retrieveCertDetailsNintyDays(noOfDays);
	}

}
