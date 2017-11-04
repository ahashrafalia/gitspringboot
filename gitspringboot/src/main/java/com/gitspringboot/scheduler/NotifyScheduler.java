package com.gitspringboot.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotifyScheduler {

	@Scheduled(cron="0 15 22 ? * *")
	public void demoServiceMethod(){
	        System.out.println("Method executed at every 10.42PM seconds. Current time is :: "+ new Date());
	}
}
