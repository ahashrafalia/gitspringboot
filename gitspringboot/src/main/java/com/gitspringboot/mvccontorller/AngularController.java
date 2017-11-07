package com.gitspringboot.mvccontorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc/")
public class AngularController {

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
}
