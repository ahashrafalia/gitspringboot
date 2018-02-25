package com.dp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.db.bean.LoginBean;
import com.dp.dao.LoginRepository;
import com.dp.dao.PersonRepository;
import com.dp.entity.Certusers;
import com.dp.exception.BusinessException;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional
	public String doLogin(LoginBean loginBean)throws BusinessException{
		Certusers cu=new Certusers();
		cu.setName(loginBean.getUname());
		cu.setPass(loginBean.getPassword());
		return loginRepository.doLogin( cu);
	}
}
