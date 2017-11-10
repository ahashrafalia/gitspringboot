package com.gitspringboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitspringboot.bean.AddressBean;
import com.gitspringboot.model.HelloLog;

@Controller
@RequestMapping("rest")
public class AngularFormController {

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/addAddress",method=RequestMethod.POST)
	public ResponseEntity<String>  addAddress(@RequestBody AddressBean addressForm){
		return new ResponseEntity<String>("string response", HttpStatus.OK);
	}
}
