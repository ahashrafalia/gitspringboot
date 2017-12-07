package com.gitspringboot.scheduler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.xml.ws.ServiceMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gitspringboot.config.SchedulerProperties;
import com.gitspringboot.dao.CertStatusRepository;
import com.gitspringboot.model.CertDetails;
import com.gitspringboot.service.NotifyService;

@Service
public class CertStatusScheduler {
	@Autowired
	SchedulerProperties schedulerProperties;

	@Autowired
	NotifyService notifyService;

	@Autowired
	CertStatusRepository certStatusRepository;

	static final String time = "0 * * * * *";

	 @Scheduled(cron="0 15 22 ? * *")// everyday 22.15 mins
	//@Scheduled(cron = time) //
	public void demoServiceMethod() {

		System.out.println("Method executed at every 10.42PM seconds. Current time is :: " + new Date() + " from prop="
				+ schedulerProperties.getNintyDays());
		List<CertDetails> productsInBatch = certStatusRepository
				.retrieveCertDetailsNintyDaysNotNEW(schedulerProperties.getNintyDays());
		for (CertDetails certDetails : productsInBatch) {
			certDetails.setStatus("ABT_EXP");
		}
		certStatusRepository.save(productsInBatch);

	}
}
