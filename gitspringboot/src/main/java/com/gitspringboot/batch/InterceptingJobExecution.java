package com.gitspringboot.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class InterceptingJobExecution implements JobExecutionListener{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void beforeJob(JobExecution jobExecution) {
		//
		// Can Log || do some business code
		//
		System.out.println("Intercepting Job Excution - Before Job!");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		//
		// Can Log || do some Business code
		//
		System.out.println("Intercepting Job Excution - After Job!");
	}

}