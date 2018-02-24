package com.dp.service;

import com.db.bean.LoginBean;
import com.dp.exception.BusinessException;

public interface LoginService {
	public String doLogin(LoginBean loginBean)throws BusinessException;
}
