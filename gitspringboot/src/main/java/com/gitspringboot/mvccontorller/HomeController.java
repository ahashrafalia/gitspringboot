package com.gitspringboot.mvccontorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc/")
public class HomeController {

	static final  String PAGE="home";
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return PAGE;
		
	}
}
