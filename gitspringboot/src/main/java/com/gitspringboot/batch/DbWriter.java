package com.gitspringboot.batch;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.gitspringboot.model.ClientMaster;
import com.gitspringboot.dao.ClientMasterRepository;
import com.gitspringboot.model.CertMaster;
import com.gitspringboot.model.ClientMaster_;
import com.gitspringboot.model.ContactMaster;
import com.gitspringboot.service.ClientMasterService;

public class DbWriter implements ItemWriter<CertCsv> {
	
	@Autowired
	ClientMasterService clientMasterService;

	@Override
	public void write(List<? extends CertCsv> ccs) throws Exception {
		System.out.println("ccs size="+ccs.size());
		for (CertCsv  cc: ccs) {
			System.out.println("Writing the data using batch writer: " + cc);
			ClientMaster clientm=new ClientMaster();
			clientm.setClientName(cc.getClientName());
			clientm.setStatus(cc.getStatus());
			
			Set<CertMaster> certSet=new LinkedHashSet<>();
			CertMaster cm=new CertMaster();
			cm.setCertName(cc.getCertName());
			cm.setCertStatus(cc.getCertStatus());
			cm.setClientMaster(clientm);
			cm.setCreatedDate(cc.getCertCreatedDate());
			cm.setExpDate(cc.getExpDate());
			cm.setRenewedDate(cc.getRenewedDate());
			certSet.add(cm);
			clientm.setCertMaster(certSet);
			
			ContactMaster contm=new ContactMaster();
			contm.setClientMaster(clientm);
			contm.setFirstName(cc.getFirstName());
			contm.setLastName(cc.getLastName());
			contm.setPhoneNo(cc.getPhNo());
			contm.setEmail(cc.getEmail());
			contm.setCountry(cc.getCountry());
			
			clientm.setContactMaster(contm);
			
			
			
			clientMasterService.save(clientm);
			
			
		}
		Thread.sleep(7000);

	}

}
