package com.gitspringboot.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.gitspringboot.bean.CertDetailMap;
import com.gitspringboot.dao.CertMasterSpecification;
import com.gitspringboot.dao.ClientMasterSpecification;
import com.gitspringboot.exception.BusinessException;
import com.gitspringboot.model.CertMaster;
import com.gitspringboot.model.ClientMaster;
import com.gitspringboot.model.Response;
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
	
	//@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="certSpec",method=RequestMethod.GET)
	public List<CertMaster> certSpec(){
		
		Specification<CertMaster> spec = CertMasterSpecification.withDate();
		List<CertMaster> list= certMasterService.withDate(spec);
		return list;
	}
	
	@RequestMapping(value="certPagable",method=RequestMethod.GET)
	public  ResponseEntity<Page<CertMaster>> certPagable( Pageable pagable)throws BusinessException{
		

		Page<CertMaster> list=certMasterService.getAllCertPagable(pagable);
		return new ResponseEntity<Page<CertMaster>>(list, HttpStatus.OK);

	}
	//@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="cert",method=RequestMethod.GET)
	public ResponseEntity<List<CertMaster>> cert()throws BusinessException{
		
		//List<CertMaster> list=certMasterService.searchCertViaProcedure("", "30-Nov-17", "30-Dec-17");
		List<CertMaster> list=certMasterService.getAllCertViaProcedure();
		return new ResponseEntity<>(list, HttpStatus.OK);
		//return (ResponseEntity<List<CertMaster>>)list;
	}
	
	 @RequestMapping(value = "/cert/{id}", method = RequestMethod.GET)
	    public ResponseEntity<CertMaster> getUser(@PathVariable("id") long id) throws BusinessException{
	        System.out.println("Fetching CertMaster with id " + id);
	        CertMaster user = certMasterService.getById(Long.valueOf(id));
	        if (user == null || user.getCertId() <= 0){
	            throw new BusinessException("ToDo doesn´t exist");
	        }
	        if (user == null) {
	            System.out.println("CertMaster with id " + id + " not found");
	            return new ResponseEntity<CertMaster>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<CertMaster>(user, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/cert/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Response>  deleteUser(@PathVariable("id") long id)throws BusinessException {
	        System.out.println("Fetching & Deleting CertMaster with id " + id);
	  
	        CertMaster user = certMasterService.getById(Long.valueOf(id));
	        if (user == null || user.getCertId() <= 0){
	            throw new BusinessException("Certificate does not exists");
	    	}
	  
	        certMasterService.delete(Long.valueOf(id));
	        //return new ResponseEntity<CertMaster>(HttpStatus.NO_CONTENT);
	        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Cert has been deleted"), HttpStatus.OK);
		}
   
	 
	
	 @RequestMapping(value = "cert", method = RequestMethod.POST)
		public ResponseEntity<CertMaster> createCert(@RequestBody CertMaster certMaster)throws BusinessException {
	          
		 System.out.println(certMaster);
	        CertMaster dbcertMaster = certMasterService.save(certMaster);
	          
	        
	  
	        
	        
	        return new ResponseEntity<CertMaster>(HttpStatus.OK);
	  }
	 
	@RequestMapping(value = "cert/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CertMaster> updateUser(@PathVariable("id") long id, @RequestBody CertMaster certMaster)throws BusinessException {
        System.out.println("Updating certi " + id);
          
        CertMaster dbcertMaster = certMasterService.getById(Long.valueOf(id));
          
        if (dbcertMaster==null) {
            System.out.println("certificate with id " + id + " not found");
            return new ResponseEntity<CertMaster>(HttpStatus.NOT_FOUND);
        }
  
        dbcertMaster.setCertName(certMaster.getCertName());
        dbcertMaster.setCertStatus(certMaster.getCertStatus());
        dbcertMaster.setExpDate(certMaster.getExpDate());
        
        CertMaster updated=certMasterService.save(dbcertMaster);
        System.out.println("updated="+updated);
        
        return new ResponseEntity<CertMaster>(updated, HttpStatus.OK);
    }
	
	//@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="certCountClient",method=RequestMethod.GET)
	public ResponseEntity<CertDetailMap>  certCountClient(){
		
		//List<CertMaster> list=certMasterService.searchCertViaProcedure("", "30-Nov-17", "30-Dec-17");
		LocalDate local90=LocalDate.now().plusDays(91);
		LocalDate local60=LocalDate.now().plusDays(61);
		LocalDate local30=LocalDate.now().plusDays(31);
		LocalDate local15=LocalDate.now().plusDays(16);
		
		Date date90 = Date.from(local90.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date date60 = Date.from(local60.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date date30 = Date.from(local30.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date date15 = Date.from(local15.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		
		List<CertMaster> list=certMasterService.getCertCountClient();
		List<CertMaster> list60_90=list.stream().filter(v->v.getExpDate().after(date60)&& v.getExpDate().before(date90)).collect(Collectors.toList());
		List<CertMaster> list30_60=list.stream().filter(v->v.getExpDate().after(date30)&& v.getExpDate().before(date60)).collect(Collectors.toList());
		List<CertMaster> list15_30=list.stream().filter(v->v.getExpDate().after(date15)&& v.getExpDate().before(date30)).collect(Collectors.toList());
		List<CertMaster> list_15=list.stream().filter(v->v.getExpDate().before(date15)).collect(Collectors.toList());
		
		System.out.println("list60_90 size="+list60_90.size()+","+list60_90);
		System.out.println("list30_60 size="+list30_60.size()+","+list30_60);
		System.out.println("list15_30 size="+list15_30.size()+","+list15_30);
		System.out.println("list15 size="+list_15.size()+","+list_15);
		Map<String,Object> certCountMap=new LinkedHashMap<>();
		certCountMap.put("good",String.valueOf(list60_90.size()));
		certCountMap.put("safe",String.valueOf( list30_60.size()));
		certCountMap.put("warn", String.valueOf(list15_30.size()));
		certCountMap.put("risk", String.valueOf(list_15.size()));
		certCountMap.put("goodlist",list60_90);
		certCountMap.put("safelist",list30_60);
		certCountMap.put("warnlist",list15_30);
		certCountMap.put("risklist",list_15);
		
		CertDetailMap cmap=new CertDetailMap();
		
		
		Map<String,String> mapCertSatuslist=new LinkedHashMap<>();
		mapCertSatuslist.put("good",String.valueOf(list60_90.size()));
		mapCertSatuslist.put("safe",String.valueOf(list30_60.size()));
		mapCertSatuslist.put("warn",String.valueOf(list15_30.size()));
		mapCertSatuslist.put("risk",String.valueOf(list_15.size()));
		
		Map<String,List<CertMaster>> mapCertlist=new LinkedHashMap<>();
		mapCertlist.put("goodlist",list60_90);
		mapCertlist.put("safelist",list30_60);
		mapCertlist.put("warnlist",list15_30);
		mapCertlist.put("risklist",list_15);
		cmap.setMapCertlist(mapCertlist);
		cmap.setMapCertStatuslist(mapCertSatuslist);
		return new ResponseEntity<CertDetailMap>(cmap,HttpStatus.OK);
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
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
