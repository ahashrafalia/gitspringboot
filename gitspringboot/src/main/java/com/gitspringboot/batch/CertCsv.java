package com.gitspringboot.batch;

import java.util.Date;

public class CertCsv {
	
	private String clientName;
	private String status;
	private Date createdDate;
	
	private String certName;
	private Date certCreatedDate;
	private Date renewedDate;
	private Date expDate;
	private String certStatus;
	
	private String firstName;
	private String lastName;
	private String phNo;
	private String email;
	private String country;
	
	
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public Date getCertCreatedDate() {
		return certCreatedDate;
	}
	public void setCertCreatedDate(Date certCreatedDate) {
		this.certCreatedDate = certCreatedDate;
	}
	public Date getRenewedDate() {
		return renewedDate;
	}
	public void setRenewedDate(Date renewedDate) {
		this.renewedDate = renewedDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getCertStatus() {
		return certStatus;
	}
	public void setCertStatus(String certStatus) {
		this.certStatus = certStatus;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "CertCsv [clientName=" + clientName + ", certName=" + certName + ", expDate=" + expDate + "]";
	}
	
	
	
}
