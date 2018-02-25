package com.dp.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.db.bean.LoginBean;
import com.dp.service.LoginService;


@ManagedBean
@SessionScoped
public class LoginController  extends SpringBeanAutowiringSupport{

	/**
	 * 
	 */

	final static Logger logger = Logger.getLogger(LoginController.class);
	
	
	
	@Autowired
	LoginService loginService;
	
	LoginBean loginBean=new LoginBean();


	public void onClick() {
		try {
			logger.info("loginservice=");
			
			loginBean.setUname(loginBean.getUname().trim());
			loginBean.setPassword(loginBean.getPassword().trim());
			
			if (loginBean.getUname() == null || loginBean.getUname().isEmpty() ||
					loginBean.getPassword() == null || loginBean.getPassword().isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Username or Password emtpy", "Authentication Error"));
				
				return;
			}
			if(loginService.doLogin(loginBean).equalsIgnoreCase("ok")){
				FacesContext.getCurrentInstance().getExternalContext().redirect("./landing.xhtml");	
			}else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Incorrect Username or Password", "Authentication Error"));
				
			}
			System.out.println("loginBean="+loginBean);
			
			
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
		}
		}


	public LoginBean getLoginBean() {
		return loginBean;
	}


	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}


		
}
