package com.gitspringboot.batch;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Component
public class InterceptingJobExecution implements JobExecutionListener{
	
	@Autowired
	private JavaMailSender sender;
	
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
		try {
			sendEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Intercepting Job Excution - After Job!");
	}
	
	 private void sendEmail() throws Exception{
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        
	        helper.setTo("emailhere@gmail.com");
	        helper.setText("How are you?");
	        helper.setSubject("Hi");
	        
	        sender.send(message);
	    }
}