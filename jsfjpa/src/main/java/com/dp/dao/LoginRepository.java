package com.dp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.bean.LoginBean;
import com.dp.entity.Certusers;
import com.dp.exception.BusinessException;

public interface LoginRepository extends JpaRepository<Certusers, Integer>,LoginRepositoryCustom{

	
}
