package com.gitspringboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/secured/")
public class CertificateController {

	 //@PreAuthorize("hasRole('ROLE_CLIENT') AND hasRole('ROLE_TECH')")
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="client",method=RequestMethod.GET)
	public String client(){
		return "client";
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
