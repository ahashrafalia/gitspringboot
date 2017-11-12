package com.gitspringboot.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitspringboot.config.SchedulerProperties;
import com.gitspringboot.dao.CertStatusRepository;
import com.gitspringboot.dao.NotifyRepository;
import com.gitspringboot.model.CertDetails;

@Service
public class CertStatusImpl implements CertStatusService {
	
	@Autowired
	NotifyRepository notifyRepository;
	
	@Autowired
	CertStatusRepository certStatusRepository;
	
	@Autowired
	SchedulerProperties schedulerProperties;

	@Override
	public CertDetails save(CertDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CertDetails getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CertDetails> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CertDetails> saveBatchUpdate(List<CertDetails> entities) {
		//return certStatusRepository.retrieveCertDetailsNintyDaysNotNEW(schedulerProperties.getNintyDays());
		List<CertDetails> productsInBatch = certStatusRepository.retrieveCertDetailsNintyDaysNotNEW(schedulerProperties.getNintyDays());
       /* for (int i = 0; i < n; i++) {
        	CertDetails p = new CertDetails(i);
            productsInBatch.add(p);
        }  */   
        for (CertDetails certDetails : productsInBatch) {
        	certDetails.setStatus("ABT_EXP");
		}

        //long start = System.nanoTime();

        // persist via batching
        return certStatusRepository.save(productsInBatch);
		
	}

	@Override
	public List<CertDetails> retrieveCertDetailsNintyDays() {
		
		return notifyRepository.retrieveCertDetailsNintyDays(schedulerProperties.getNintyDays());
	}

}
