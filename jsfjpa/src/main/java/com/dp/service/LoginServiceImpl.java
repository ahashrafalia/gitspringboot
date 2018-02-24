package com.dp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.db.bean.LoginBean;
import com.dp.dao.LoginDao;
import com.dp.exception.BusinessException;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	
	@Transactional
	public String doLogin(LoginBean loginBean)throws BusinessException{
		return loginDao.doLogin( loginBean);
	}
}
