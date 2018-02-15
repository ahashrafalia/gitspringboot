package com.gitspringboot.mvccontorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitspringboot.zample.SuperInterface;

@Controller
public class CertMvcController {

	@Autowired
	SuperInterface superInterface;
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@RequestMapping(value="/certHomeClient",method=RequestMethod.GET)
	public String index(){
		
		superInterface.show();
		return "certHomeClient";
	}
	@PreAuthorize("hasAnyRole('ROLE_TECH')")
	@RequestMapping(value="/certHomeTech",method=RequestMethod.GET)
	public String indexTech(){
		return "certHomeTech";
	}
}
