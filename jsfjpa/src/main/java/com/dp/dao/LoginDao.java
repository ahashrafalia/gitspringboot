package com.dp.dao;

import com.db.bean.LoginBean;
import com.dp.exception.BusinessException;

public interface LoginDao {

	public String doLogin(LoginBean loginBean)throws BusinessException;
}
