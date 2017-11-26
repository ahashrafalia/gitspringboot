package com.gitspringboot.service;

import java.util.List;

import com.gitspringboot.exception.BusinessException;
import com.gitspringboot.model.HelloLog;

public interface IHelloService  extends ICRUDService<HelloLog>{

	public List<HelloLog> findByAVeryComplicatedQuery(Long id, String name) throws BusinessException;
		
}
