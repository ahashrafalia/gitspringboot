package com.gitspringboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="CertMaster")
@Table(name="CERTMASTER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "certId")
public class CertMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "certMaster_seq")
	@SequenceGenerator(sequenceName = "certMaster_seq", allocationSize = 1, name = "certMaster_seq")
	@Column(name="CERT_ID")
	private long certId;
	
	@Column(name = "CERT_NAME", length = 50)
    private String certName;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	
	@Column(name = "RENEWED_DATE")
	private Date renewedDate;
	
	
	@Column(name = "EXP_DATE")
	private Date expDate;
	
		
	@Column(name = "CERT_STATUS", length = 50)
    private String certStatus;
	
	
	@ManyToOne
	//@JsonBackReference 
	@JoinColumn(name="CLIENT_ID")
	private ClientMaster clientMaster;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public ClientMaster getClientMaster() {
		return clientMaster;
	}

	public void setClientMaster(ClientMaster clientMaster) {
		this.clientMaster = clientMaster;
	}

	/*@Override
	public String toString() {
		return "CertMaster [certId=" + certId + ", certName=" + certName + ", createdDate=" + createdDate
				+ ", renewedDate=" + renewedDate + ", expDate=" + expDate + ", certStatus=" + certStatus
				+ ", clientMaster=" + clientMaster + "]";
	}*/

	
	
}
