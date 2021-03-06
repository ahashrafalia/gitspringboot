package com.gitspringboot.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity(name="ClientMaster")
@Table(name="CLIENTMASTER")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "clientId")
public class ClientMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "clientMaster_seq")
	@SequenceGenerator(sequenceName = "clientMaster_seq", allocationSize = 1, name = "clientMaster_seq")
	@Column(name="CLIENT_ID")
	private long clientId;
	
	@Column(name = "CLIENT_NAME", length = 50)
    private String clientName;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	
	@Column(name = "STATUS", length = 50)
    private String status;
	
	//@JsonIgnore
	@JsonManagedReference 
	@OneToMany(mappedBy="clientMaster",fetch=FetchType.LAZY,targetEntity=CertMaster.class,cascade = CascadeType.ALL)
	private Set<CertMaster> certMaster;

	 // @Transient
	@OneToOne(mappedBy="clientMaster",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=ContactMaster.class)
    private ContactMaster contactMaster;
	  
	  
	  

	public ClientMaster() {
		super();
	}


	public long getClientId() {
		return clientId;
	}


	public void setClientId(long clientId) {
		this.clientId = clientId;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Set<CertMaster> getCertMaster() {
		return certMaster;
	}


	public void setCertMaster(Set<CertMaster> certMaster) {
		this.certMaster = certMaster;
	}


	public ContactMaster getContactMaster() {
		return contactMaster;
	}


	public void setContactMaster(ContactMaster contactMaster) {
		this.contactMaster = contactMaster;
	}


	/*@Override
	public String toString() {
		return "ClientMaster [clientId=" + clientId + ", clientName=" + clientName + ", createdDate=" + createdDate
				+ ", status=" + status + ", certMaster=" + certMaster + "]";
	}*/


	

}
