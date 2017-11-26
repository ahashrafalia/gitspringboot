package com.gitspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gitspringboot.exception.BusinessException;
import com.gitspringboot.model.Article;
import com.gitspringboot.model.HelloLog;
import com.gitspringboot.service.IHelloService;

@Controller
@RequestMapping("rest")
public class HelloController {

	@Autowired
	IHelloService helloService;
	
	@GetMapping("helloList/{id}/{name}")
	public ResponseEntity<List<HelloLog>> getArticleByIdName(@PathVariable("id") Long id,
			@PathVariable("name") String name)throws BusinessException {
		List<HelloLog> list = helloService.findByAVeryComplicatedQuery(id, name);
		return new ResponseEntity<List<HelloLog>>(list, HttpStatus.OK);
	}
	
	@GetMapping("helloList")
	public ResponseEntity<List<HelloLog>> getAllHelloLog() {
		List<HelloLog> list = helloService.getAll();
		return new ResponseEntity<List<HelloLog>>(list, HttpStatus.OK);
	}
}
