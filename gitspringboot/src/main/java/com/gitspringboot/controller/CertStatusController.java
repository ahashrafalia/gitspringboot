package com.gitspringboot.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gitspringboot.aop.AuditLogA;
import com.gitspringboot.model.CertDetails;
import com.gitspringboot.service.CertStatusService;

@Controller
@RequestMapping("/rest/")
public class CertStatusController {

	@Autowired
	CertStatusService certStatusService;
	
	
	@AuditLogA
	@RequestMapping(value="/dashboard/{param}",method=RequestMethod.GET)
	public String runCertStatus(@PathVariable String param){
		//List<CertDetails> listupdate =certStatusService.saveBatchUpdate(new ArrayList<CertDetails>());
		//System.out.println("listUpdated="+listupdate.size());
		List<CertDetails> list60=null;
		List<CertDetails> list30=null;
		List<CertDetails> list15=null;
		List<CertDetails> list5=null;
		
		List<CertDetails> list90=certStatusService.retrieveCertDetailsNintyDays();
		
		LocalDate local60=LocalDate.now().plusDays(60);
		LocalDate local30=LocalDate.now().plusDays(30);
		LocalDate local15=LocalDate.now().plusDays(15);
		
		Date date60 = Date.from(local60.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date date30 = Date.from(local30.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date date15 = Date.from(local15.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println(local60+"="+date60);
		System.out.println(local30+"="+date30);
		/*List<String> strAmounts = getTransactionsForAccount(id)
		        .stream()
		        .filter(t -> t.amount > 0)                           //remove all negative transactions
		        .filter(t -> startDate.before(t.date) && endDate.after(t.date)) //filter by date
		        .sorted((t1, t2) -> t1.date.compareTo(t2.date))                 //sort by date
		        .limit(10)                                                      //limit to 10 transactions
		        .mapToDouble(t -> return t.amount * getExchangeRate())          //convert to pounds
		        .map(pounds -> return "£" + pounds)                             //convert to string
		        .collect(Collectors.toList());   */
		list60=	list90.stream().filter(v->v.getExpDate().after(date30) && v.getExpDate().before(date60)).collect(Collectors.toList());
		list30=	list90.stream().filter(v->v.getExpDate().after(date15) && v.getExpDate().before(date30)).collect(Collectors.toList());
		list15=	list90.stream().filter(v->v.getExpDate().after(new Date()) && v.getExpDate().before(date15)).collect(Collectors.toList());
		System.out.println("list60 size="+list60.size()+"="+list60);
		System.out.println("list30 size="+list30.size()+"="+list30);
		System.out.println("list15 size="+list15.size()+"="+list15);
		return "dashboard";
	}
}
