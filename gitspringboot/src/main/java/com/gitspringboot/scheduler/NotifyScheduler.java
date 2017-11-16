package com.gitspringboot.scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gitspringboot.config.SchedulerProperties;
import com.gitspringboot.model.CertDetails;
import com.gitspringboot.service.NotifyService;

@Service
public class NotifyScheduler {
	
	@Autowired
	SchedulerProperties schedulerProperties;
	
	@Autowired
	NotifyService notifyService;
	
	static final String time="0 * * * * *";

	@Scheduled(cron="0 15 22 ? * *")// everyday 22.15 mins
	//@Scheduled(cron=time)//
	public void demoServiceMethod(){
		
		System.out.println("Method executed at every 10.42PM seconds. Current time is :: "+ new Date()+" from prop="+schedulerProperties.getNintyDays());
		LocalDate localDate = LocalDate.now();
		LocalDate localNinty=localDate.plusDays(schedulerProperties.getNintyDays());
		//System.out.println("localDate="+localDate+",localNinty="+localNinty);
		//Date currentDatePlusOneDay = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		Date localNintyDate = Date.from(localNinty.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//System.out.println("localDate="+localDate+",localNinty="+localNinty+",localNintyDate="+localNintyDate);
		List<CertDetails> listCert=notifyService.retrieveCertDetailsNintyDays(schedulerProperties.getNintyDays());
		System.out.println("listCert="+listCert);
						 
	}
}
