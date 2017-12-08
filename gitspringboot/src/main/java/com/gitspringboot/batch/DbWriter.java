package com.gitspringboot.batch;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.gitspringboot.model.ClientMaster;
import com.gitspringboot.dao.ClientMasterRepository;
import com.gitspringboot.dao.ClientMasterSpecification;
import com.gitspringboot.model.CertMaster;
import com.gitspringboot.model.ClientMaster_;
import com.gitspringboot.model.ContactMaster;
import com.gitspringboot.service.ClientMasterService;

public class DbWriter implements ItemWriter<CertCsv> {
	
	@Autowired
	ClientMasterService clientMasterService;
	
	@Autowired
	ClientMasterRepository clientMasterRepository;

	@Override
	public void write(List<? extends CertCsv> ccs) throws Exception {
		System.out.println("ccs size="+ccs.size());
		for (CertCsv  cc: ccs) {
			Specification<ClientMaster> spec=	ClientMasterSpecification.withDynamicQuery(cc.getClientName().toLowerCase());
			ClientMaster dbclient=null;
			List<ClientMaster> list= clientMasterService.findByClientName(spec);
			System.out.println("list size="+list.size());
			if(null!=list && list.size()!=0){
				dbclient=list.get(0);
			}
			
			System.out.println("dbcliet="+dbclient);
			//System.out.println("Writing the data using batch writer: " + cc+" , client exist="+clientMasterService.existsByclientName(cc.getClientName()));
			if(null!=dbclient && cc.getClientName().equalsIgnoreCase(dbclient.getClientName())){
				System.out.println("dbcliet="+cc.getClientName()+"="+dbclient.getClientName());
				dbclient.setStatus(cc.getStatus());
				Set<CertMaster> certSet=new LinkedHashSet<>();
				CertMaster cm=new CertMaster();
				cm.setCertName(cc.getCertName());
				cm.setCertStatus(cc.getCertStatus());
				cm.setClientMaster(dbclient);
				cm.setCreatedDate(cc.getCertCreatedDate());
				cm.setExpDate(cc.getExpDate());
				cm.setRenewedDate(cc.getRenewedDate());
				certSet.add(cm);
				dbclient.setCertMaster(certSet);
				
				
				ContactMaster contm=new ContactMaster();
				contm.setClientMaster(dbclient);
				contm.setFirstName(cc.getFirstName());
				contm.setLastName(cc.getLastName());
				contm.setPhoneNo(cc.getPhNo());
				contm.setEmail(cc.getEmail());
				contm.setCountry(cc.getCountry());
				
				clientMasterService.save(dbclient);
			}else{
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
			
			
			
		}
		Thread.sleep(7000);

	}

}
