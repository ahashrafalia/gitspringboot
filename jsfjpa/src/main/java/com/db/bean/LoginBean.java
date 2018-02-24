package com.db.bean;

public class LoginBean {

	private String uname;
	private String password;
	
	public LoginBean(){
		
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginBean [uname=" + uname + ", password=" + password + "]";
	}
	
	
}
