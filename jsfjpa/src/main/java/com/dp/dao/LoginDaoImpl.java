package com.dp.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db.bean.LoginBean;
import com.dp.entity.Certusers;
import com.dp.exception.BusinessException;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	Logger log=Logger.getLogger(LoginDaoImpl.class);
	
	//@Autowired
	private SessionFactory sessionFactory;

	public String doLogin(LoginBean loginBean)throws BusinessException {
		try {
			log.info("inside LoginDaoImpl doLogin=" + loginBean);
			String qry = "from certusers cu where cu.name=:name and cu.pass=:pass";
			Query query = sessionFactory.getCurrentSession().createQuery(qry);
			query.setString("name", loginBean.getUname());
			query.setString("pass", loginBean.getPassword());
			Certusers lb = (Certusers) query.uniqueResult();
			log.info("inside LoginDaoImpl doLogin=" + lb);
			if (lb != null) {
				return "ok";
			} else {
				return "";
			} 
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		}
		
	
	}
	
	

}
