package com.gitspringboot.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gitspringboot.dao.HelloLogRepository;
import com.gitspringboot.exception.BusinessException;
import com.gitspringboot.model.HelloLog;

@Service
@Transactional
public class HelloService implements IHelloService {
	
	@Autowired
	HelloLogRepository helloDao;

	@Override
	public HelloLog save(HelloLog entity) {
		System.out.println("This is hello service");
		HelloLog hl= helloDao.save(entity);
		
		return hl;
		
	}

	@Override
	public HelloLog getById(Serializable id) {
		
		return helloDao.findByUid((Integer)id);
		
	}

	@Override
	public List<HelloLog> getAll() {
		
		return helloDao.findAll();
	}

	@Override
	public void delete(Serializable id) {
		 helloDao.delete((Integer)id);
	}

	@Override
	public List<HelloLog> findByAVeryComplicatedQuery(Long id, String name) throws BusinessException{
		List<HelloLog> list=helloDao.findByAVeryComplicatedQuery(id, name);
		System.out.println("list="+list);
		if (list.isEmpty()) {
            throw new BusinessException( "user not found");
        }else{
        	return list;
        }
	}

}
