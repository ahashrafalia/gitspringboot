package com.gitspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitspringboot.model.CertDetails;
import com.gitspringboot.service.CertStatusService;

@Controller
@RequestMapping("/rest/")
public class CertStatusController {

	@Autowired
	CertStatusService certStatusService;
	
	@RequestMapping(value="/changeCertStatus",method=RequestMethod.GET)
	public String runCertStatus(){
		List<CertDetails> listupdate =certStatusService.saveBatchUpdate(new ArrayList<CertDetails>());
		System.out.println("listUpdated="+listupdate.size());
		return "";
	}
}
