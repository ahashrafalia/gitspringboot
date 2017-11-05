package com.gitspringboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CERT_DETAILS")
public class CertDetails implements Serializable {

	
	private static final long serialVersionUID = 4778035617171828886L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CERT_SEQ")
	@SequenceGenerator(sequenceName = "CERT_SEQ", allocationSize = 1, name = "CERT_SEQ")
	@Column(name="CERT_ID")
	private long certId;
	
	@Column(name = "CERT_NAME", length = 50)
    private String certName;
	
	@Column(name = "EXP_DATE")
	private Date expDate;
	
	@Column(name = "CONTACT_NAME", length = 50)
    private String contactName;
	
	@Column(name = "CONTACT_EMAIL", length = 50)
    private String contactEmail;
	
	@Column(name = "CERT_STATUS", length = 50)
    private String status;

	public long getCertId() {
		return certId;
	}

	public void setCertId(long certId) {
		this.certId = certId;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CertDetails [certId=" + certId + ", certName=" + certName + ", expDate=" + expDate + ", contactName="
				+ contactName + ", contactEmail=" + contactEmail + ", status=" + status + "]";
	}

	
	 
	

}
