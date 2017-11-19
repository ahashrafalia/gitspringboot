package com.gitspringboot.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gitspringboot.dao.CertMasterSpecification;
import com.gitspringboot.dao.ClientMasterSpecification;
import com.gitspringboot.model.CertMaster;
import com.gitspringboot.model.ClientMaster;
import com.gitspringboot.service.CertMasterService;
import com.gitspringboot.service.ClientMasterService;

@RestController
@RequestMapping("/rest/secured/")
public class CertificateController {
	
	@Autowired
	ClientMasterService clientMasterService;
	
	@Autowired
	CertMasterService certMasterService;

	 //@PreAuthorize("hasRole('ROLE_CLIENT') AND hasRole('ROLE_TECH')")
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="client",method=RequestMethod.GET)
	public String client(){
		return "client";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="clientDashboard",method=RequestMethod.GET)
	public List<ClientMaster> clientDashboard(){
		List<ClientMaster> list= clientMasterService.getAll();
		
		//System.out.println("list from controller="+list);
		return list;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="certSpec",method=RequestMethod.GET)
	public List<CertMaster> certSpec(){
		
		Specification<CertMaster> spec = CertMasterSpecification.withDate();
		List<CertMaster> list= certMasterService.withDate(spec);
		return list;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="certSearch",method=RequestMethod.GET)
	public List<CertMaster> certSearch(){
		
		List<CertMaster> list=certMasterService.searchCertViaProcedure("", "30-Nov-17", "30-Dec-17");
		return list;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="clientSpec",method=RequestMethod.GET)
	public List<ClientMaster> clientSpec(){
				
		
		Specification<ClientMaster> spec=	ClientMasterSpecification.withDynamicQuery("Virtusa");
		
		List<ClientMaster> list= clientMasterService.findByClientName(spec);
		return list;
		
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_TECH')")
	@RequestMapping(value="tech",method=RequestMethod.GET)
	public String tech(){
		return "tech";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_CET')")
	@RequestMapping(value="cet",method=RequestMethod.GET)
	public String cet(){
		return "cet";
	}
}
