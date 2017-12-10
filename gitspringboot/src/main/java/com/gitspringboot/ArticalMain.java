package com.gitspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ArticalMain extends SpringBootServletInitializer {
	 
	

	public static void main(String[] args) {
		SpringApplication.run(ArticalMain.class, args);	
	}
	
	@Override
	protected SpringApplicationBuilder configure(
	    SpringApplicationBuilder application) {
	    return application.sources(ArticalMain.class);
	  }

}
