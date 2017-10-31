package com.gitspringboot.service;

import java.util.List;

import com.gitspringboot.model.HelloLog;

public interface IHelloService  extends ICRUDService<HelloLog>{

	public List<HelloLog> findByAVeryComplicatedQuery(Long id, String name) ;
		
}
