package com.gitspringboot.mvccontorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitspringboot.dao.HelloLogRepository;
import com.gitspringboot.model.Article;
import com.gitspringboot.model.HelloLog;
import com.gitspringboot.service.IHelloService;

@Controller
@RequestMapping("/mvc/")
public class HelloMvcController {
	
	//@Autowired
	//IHelloLogDAO hellodao;
	@Autowired
	IHelloService helloService;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloForm(){
		return "hello";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public String hello(HttpServletRequest request,Model model){
		String name=request.getParameter("name");
		if(name==null || name==""){
			name="world";
		}
		HelloLog log=new HelloLog(name);
		model.addAttribute("name", name);
		model.addAttribute("title","Hello spring Response");
		HelloLog log2=helloService.save(log);
		return "hello";
	}
	
	
}
