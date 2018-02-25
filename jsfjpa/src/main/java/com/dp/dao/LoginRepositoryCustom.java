package com.dp.dao;

import com.dp.entity.Certusers;
import com.dp.exception.BusinessException;

public interface LoginRepositoryCustom {

	public String doLogin(Certusers certUsers)throws BusinessException;
}
